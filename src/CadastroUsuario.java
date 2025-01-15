import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.*;

public class CadastroUsuario {

    public void executar(){
        String pathArquivo = "C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Perguntas\\formulário.txt";
        Scanner scUser = new Scanner(System.in);
        List<String> perguntas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathArquivo))) {
            String linha;
            while (((linha = br.readLine()) != null)){
                perguntas.add(linha);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] arrayRespostas = new String[perguntas.size()];

        int numPergunta = 1;

        for (int indexPergunta = 0; indexPergunta < perguntas.size(); indexPergunta++) {
            System.out.println(numPergunta+" - "+perguntas.get(indexPergunta));
            arrayRespostas[indexPergunta] = scUser.nextLine();
            numPergunta++;
        }

        try {
            validarNome(arrayRespostas[0]);
            validarEmail(arrayRespostas[1]);
            validarIdade(Integer.parseInt(arrayRespostas[2]));
            validarAltura(arrayRespostas[3]);
            verificarEmailDuplicado(arrayRespostas[1]);

            for (String arrayResposta : arrayRespostas) {
                System.out.println(arrayResposta);
            }

            Usuario usuario = new Usuario(arrayRespostas[0],arrayRespostas[1], Integer.parseInt(arrayRespostas[2]), Double.parseDouble(arrayRespostas[3]));


            int numeroFormulario = 1;
            String pathRespostas = "C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Respostas\\";
            String nomeArquivo = pathRespostas+numeroFormulario+"-"+usuario.getNome().toUpperCase().replaceAll("\\s","")+".txt";


            File respostasFormulario = new File(nomeArquivo);
            while (respostasFormulario.exists()){
                ++numeroFormulario;
                nomeArquivo = numeroFormulario+"-"+usuario.getNome().toUpperCase().replaceAll("\\s","")+".txt";
                respostasFormulario = new File(nomeArquivo);
            }

            try (FileWriter fw = new FileWriter(respostasFormulario);
                 BufferedWriter bw = new BufferedWriter(fw)){
                for (String arrayResposta : arrayRespostas){
                    bw.write(arrayResposta);
                    bw.newLine();
                }
                bw.flush();
            }catch (IOException e){
                e.printStackTrace();
            }

        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void validarNome (String nome) throws nomeInvalidoException{
        if(nome.length()<10){
            throw new nomeInvalidoException("O nome deve ter pelo menos 10 caracteres");
        }
    }

    private void validarEmail(String email) throws emailInvalidoException{
        if(!email.contains("@")){
            throw new emailInvalidoException("e-mail inválido");
        }
    }

    private void validarIdade(int idade) throws idadeInvalidaException{
        if (idade < 18){
            throw new idadeInvalidaException("O usuário deve ter mais de 18 anos.");
        }
    }

    private void validarAltura(String alturaStr) throws alturaInvalidaException{
        try {
            double altura = Double.parseDouble(alturaStr.replace(',','.'));
        }catch (NumberFormatException e){
            throw new alturaInvalidaException("A altura deve ser escrita com vírgula");
        }
    }

    private void verificarEmailDuplicado(String email) throws emailDuplicadoException{
        String pathDiretorio = "C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Respostas";
        File diretorio = new File(pathDiretorio);
        File [] arquivos = diretorio.listFiles();

        if (arquivos != null){
            for (File arquivo : arquivos){
                try {
                    try (FileReader fr = new FileReader(arquivo);
                         BufferedReader br = new BufferedReader(fr)){
                        String linha;
                        while ((linha = br.readLine()) != null){
                            if (linha.contains(email)){
                                throw new emailDuplicadoException("Já existe um usuário com esse e-mail cadastrado.");
                            }
                        }
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
