import java.util.Scanner;
import java.util.Random;

public class Descoberta {
    private Scanner scanner;
    private Random random;
    public String[] palavras;
    private String palavraEscolhida;
    private int contador; {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int contador = 0;

        String palavraEscolhida = escolherPalavra(random, palavras);
        String palavraEmbaralhada = embaralharPalavra(palavraEscolhida, random);

        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
        String opcao = lerPalavra(scanner);

        // Enquanto não acertar
        while (!opcao.equals(palavraEscolhida)) {
            exibirMenu();
            String escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                opcao = lerPalavra(scanner);
                contador++;
            } else if (escolha.equals("2")) {
                mostrarDica(palavraEscolhida);
                opcao = lerPalavra(scanner);
                contador++;
            } else {
                System.out.println("Opção inválida. Digite 1 ou 2.");
            }
        }

        System.out.println("ACERTOU!");
        System.out.println("Quantidade de erros: " + contador);
    }

    // Escolhe uma palavra aleatória
    private static String escolherPalavra(Random random, String[] palavras) {
        return palavras[random.nextInt(palavras.length)];
    }

    // Embaralha os caracteres da palavra
    private static String embaralharPalavra(String palavra, Random random) {
        char[] letras = palavra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            int j = random.nextInt(letras.length);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }
        return new String(letras);
    }

    // Lê a palavra digitada pelo usuário
    private static String lerPalavra(Scanner scanner) {
        System.out.print("Qual a palavra: ");
        return scanner.nextLine();
    }

    // Exibe o menu de opções
    private static void exibirMenu() {
        System.out.println("\nErrou! Escolha uma opção:");
        System.out.println("1 - Tentar novamente");
        System.out.println("2 - Pedir dica");
        System.out.print("Opção: ");
    }

    // Mostra a primeira e a última letra como dica
    private static void mostrarDica(String palavra) {
        char primeiraLetra = palavra.charAt(0);
        char ultimaLetra = palavra.charAt(palavra.length() - 1);
        System.out.println("Dica: Primeira Letra: " + primeiraLetra);
        System.out.println("Dica: Última Letra: " + ultimaLetra);
    }
}