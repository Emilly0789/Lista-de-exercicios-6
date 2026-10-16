import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaUsuarios {

    private static final Map<String, usuário> usuarios = new HashMap<>();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.print("\n1 - Inserir usuário");
            System.out.print(" 2 - Listar usuários");
            System.out.print(" 3 - Remover usuário");
            System.out.print(" 0 - Sair");
            System.out.print(" Escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1 -> inserir();
                case 2 -> listar();
                case 3 -> remover();
                case 0 -> System.out.println("Sistema encerrado.");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        System.out.print("Email: ");
        String email = teclado.nextLine();

        if (usuarios.containsKey(email)) {
            System.out.print("Erro: já existe um usuário com esse email.");
            return;
        }

        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        System.out.print("Senha: ");
        String senha = teclado.nextLine();

        usuarios.put(email, new usuário(email, nome, senha));
        System.out.print("Usuário cadastrado com sucesso!");
    }

    private static void listar() {
        if (usuarios.isEmpty()) {
            System.out.print("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\nUsuários cadastrados:");
        for (usuário usuario : usuarios.values()) {
            System.out.println(usuario);
        }
    }

    private static void remover() {
        System.out.print("Digite o email do usuário: ");
        String email = teclado.nextLine();

        usuário removido = usuarios.remove(email);

        if (removido == null) {
            System.out.println("Usuário não encontrado.");
        } else {
            System.out.println("Usuário removido: " + removido.getNome());
        }
    }
}
