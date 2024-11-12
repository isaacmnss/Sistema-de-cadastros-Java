public class Usuario {
    private String nome;
    private String email;
    private int idade;
    private double altura;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, String email, int idade, double altura) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void imprime(){
        System.out.println("Nome: "+this.nome);
        System.out.println("email: "+this.email);
        System.out.println("idade: "+this.idade);
        System.out.println("Altura: "+this.altura);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
}
