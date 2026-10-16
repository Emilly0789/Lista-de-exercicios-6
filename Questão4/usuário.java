public class usuário {
    private String email;
    private String nome;
    private String senha;

    public usuário(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Email: " + email + " | Nome: " + nome + " | Senha: " + senha;
    }
}