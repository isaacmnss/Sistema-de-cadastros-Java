import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ListarUsuarios {
    public void executar(){
        String pathDiretorio = "C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Respostas";
        int numUsuario = 1;
        File diretorio = new File(pathDiretorio);
        File [] arquivos = diretorio.listFiles();
        if (arquivos != null && arquivos.length > 0){
            for (File arquivo: arquivos){
                try (FileReader fr = new FileReader(arquivo);
                     BufferedReader br = new BufferedReader(fr)){
                    System.out.println(numUsuario+" - "+br.readLine());
                }catch (IOException e){
                    System.out.println("Erro ao ler o Arquivo");
                }
                numUsuario++;
            }
        } else {
            System.out.println("Nenhum usuário cadastrado");
        }
    }
}
