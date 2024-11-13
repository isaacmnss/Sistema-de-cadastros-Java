import java.io.*;
import java.util.Scanner;

public class DeletarPergunta {
    public void executar (){
        boolean isDeletado = false;
        Scanner sc = new Scanner(System.in);
        File file = new File("C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Perguntas\\formulário.txt");
        int numPergunta = 1;
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)){
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(numPergunta+" - "+linha);// retorna null quando chega ao fim do arquivo
                numPergunta++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        while (!isDeletado){
            System.out.println("Digite o número da pergunta que deseja excluir: ");
            int deleteLinha = sc.nextInt();
            if (deleteLinha <= 4){
                System.out.println("Apenas as perguntas 5 em diante podem ser excluídas, tente novamente");
            } else{
                String tempFile = "temp.txt";
                String pathArquivo = "C:\\Users\\ispit\\Documents\\Foco total\\Java\\Sistema de Cadastros\\Perguntas\\formulário.txt";
                File arquivoAntigo = new File(pathArquivo);
                File arquivoNovo = new File(tempFile);
                int linha = 0;
                String linhaAtual;

                try{
                    FileWriter fw = new FileWriter(tempFile, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    FileReader fr = new FileReader(pathArquivo);
                    BufferedReader br = new BufferedReader(fr);

                    while ((linhaAtual = br.readLine()) != null){
                        linha++;

                        if (deleteLinha != linha){
                            pw.println(linhaAtual);
                        }

                    }
                    pw.flush();
                    pw.close();
                    fr.close();
                    br.close();
                    bw.close();
                    fw.close();

                    arquivoAntigo.delete();
                    File dump = new File(pathArquivo);
                    arquivoNovo.renameTo(dump);
                    System.out.println("Pergunta deletada com sucesso");
                    isDeletado = true;
                }catch (Exception e){
                    System.out.println("Erro ao encontrar a pergunta escolhida");
                }
            }
        }

    }
}
