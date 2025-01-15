import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PesquisaUsuario {
    public void executar() {

        String pathDiretorio = "C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Respostas";
        File diretorio = new File(pathDiretorio);
        File [] arquivos = diretorio.listFiles();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome, idade ou e-mail do usuário cadastrado");
        String busca = sc.nextLine();
        if (arquivos != null){
            System.out.println("Usuários encontrados: ");
            for (File arquivo : arquivos){
                try (FileReader fr = new FileReader(arquivo);
                     BufferedReader br = new BufferedReader(fr)){
                    String linha;
                    while ((linha = br.readLine()) != null){
                        if (linha.contains(busca))
                            System.out.println(arquivo.getName());
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
