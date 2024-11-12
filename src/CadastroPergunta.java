import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroPergunta {
    public void executar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a nova Pergunta: ");
        String novaPergunta = sc.nextLine();
        File formulario = new File("C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Perguntas\\formulário.txt");
        try (FileWriter fw = new FileWriter(formulario, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(novaPergunta);
            bw.newLine();
            bw.flush();
        } catch (IOException e){
            System.out.println("Erro ao cadastrar Pergunta");
        }
        System.out.println("Pergunta cadastrada com sucesso!");
    }
}
