import java.util.Scanner;

public class Menu {
    CadastroUsuario cadastroUsuario = new CadastroUsuario();
    ListarUsuarios listarUsuarios = new ListarUsuarios();
    CadastroPergunta cadastroPergunta = new CadastroPergunta();

    public void execute(){
        System.out.println("=============================================================");
        System.out.println("Digite a opção que deseja: ");
        System.out.println("1 - Cadastrar o usuário\n" +
                "2 - Listar todos usuários cadastrados\n" +
                "3 - Cadastrar nova pergunta no formulário\n" +
                "4 - Deletar pergunta do formulário\n" +
                "5 - Pesquisar usuário por nome ou idade ou email");
        System.out.println("=============================================================");

        Scanner scannerMenu = new Scanner(System.in);
        int opc = scannerMenu.nextInt();
        switch (opc){
            case 1:
                System.out.println("1 - Cadastrar o usuário");
                cadastroUsuario.executar();
                break;
            case 2:
                System.out.println("2 - Listar todos usuários cadastrados");
                listarUsuarios.executar();
                break;
            case 3:
                System.out.println("3 - Cadastrar nova pergunta no formulário");
                cadastroPergunta.executar();
                break;
            case 4:
                System.out.println("4 - Deletar pergunta do formulário");
                break;
            case 5:
                System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
                break;
            default:
                System.out.println("Opção inválida. Encerrando aplicação...");
        }

   }

}
