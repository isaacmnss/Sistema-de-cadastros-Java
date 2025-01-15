import java.util.Scanner;

public class Menu {
    CadastroUsuario cadastroUsuario = new CadastroUsuario();
    ListarUsuarios listarUsuarios = new ListarUsuarios();
    CadastroPergunta cadastroPergunta = new CadastroPergunta();
    DeletarPergunta deletarPergunta = new DeletarPergunta();
    PesquisaUsuario pesquisaUsuario = new PesquisaUsuario();

    public void execute(){
        System.out.println("=============================================================");
        System.out.println("Digite a opção que deseja: ");
        System.out.println("""
                1 - Cadastrar o usuário
                2 - Listar todos usuários cadastrados
                3 - Cadastrar nova pergunta no formulário
                4 - Deletar pergunta do formulário
                5 - Pesquisar usuário por nome ou idade ou email""");
        System.out.println("=============================================================");

        Scanner scannerMenu = new Scanner(System.in);
        int opc = scannerMenu.nextInt();
        switch (opc){
            case 1:
                System.out.println("1 - Cadastrar o usuário\n");
                cadastroUsuario.executar();
                break;
            case 2:
                System.out.println("2 - Listar todos usuários cadastrados\n");
                listarUsuarios.executar();
                break;
            case 3:
                System.out.println("3 - Cadastrar nova pergunta no formulário\n");
                cadastroPergunta.executar();
                break;
            case 4:
                System.out.println("4 - Deletar pergunta do formulário\n");
                deletarPergunta.executar();
                break;
            case 5:
                System.out.println("5 - Pesquisar usuário por nome ou idade ou email\n");
                pesquisaUsuario.executar();
                break;
            default:
                System.out.println("Opção inválida. Encerrando aplicação...");
        }

   }

}
