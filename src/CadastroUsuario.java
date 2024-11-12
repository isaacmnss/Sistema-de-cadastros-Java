import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    }
}
