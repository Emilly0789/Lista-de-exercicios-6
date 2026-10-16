import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(-5, 3, -2, 8, 0, -7, 10);

        List<Integer> positivos = numeros.stream()
                .filter(n -> n >= 0)
                .toList();

        System.out.print("Sem negativos: " + positivos);

        List<String> nomes = Arrays.asList("Pedro", "Ana", "Paulo", "Maria", "Pietro");

        nomes.stream()
                .filter(nome -> nome.startsWith("P"))
                .forEach(System.out::println);

        String paragrafo = "Java é uma linguagem Java poderosa e Java é usada em muitos projetos";

        Set<String> palavrasUnicas = Arrays.stream(paragrafo.split("\\s+"))
                .map(palavra -> palavra.replaceAll("[^a-zA-ZÀ-ÿ]", ""))
                .filter(palavra -> !palavra.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        System.out.print("Palavras únicas: " + palavrasUnicas);
    }
}
