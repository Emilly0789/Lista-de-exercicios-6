import java.util.Scanner;
import java.util.Stack;

public class Navegador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> paginas = new Stack<>();
        String atual = "Página inicial";

        while (true) {
            System.out.print("\n    NAVEGADOR    ");
            System.out.print("Página atual: " + atual);
            System.out.print(" 1 - Acessar nova página");
            System.out.print(" 2 - Voltar");
            System.out.print(" 3 - Mostrar histórico");
            System.out.print(" 0 - Sair");
            System.out.print(" Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Título da página HTML: ");
                String pagina = sc.nextLine();

                paginas.push(atual);
                atual = pagina;
                System.out.println("Você acessou: " + atual);

            } else if (opcao == 2) {
                if (paginas.isEmpty()) {
                    System.out.println("Não há página anterior!");
                } else {
                    atual = paginas.pop();
                    System.out.println("Você voltou para: " + atual);
                }

            } else if (opcao == 3) {
                System.out.print("Histórico (mais recente no topo):");
                System.out.println(paginas);

            } else if (opcao == 0) {
                System.out.print("Encerrando o navegador...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
