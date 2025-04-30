import java.util.Scanner;

public class UtilJogo {
    Scanner scanner = new Scanner(System.in);

    public static void verificarPalavra(String palavraSelecionada, Scanner scanner) {
        int contador = 0;
        System.out.print("Digite a palavra: ");
        String tentativa = scanner.nextLine();

        while (!tentativa.equalsIgnoreCase(palavraSelecionada)) {
            UtilJogo.exibirMenuErro();
            String escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                System.out.print("Digite a palavra novamente: ");
                tentativa = scanner.nextLine();
                contador ++;
            } else if (escolha.equals("2")) {
                UtilJogo.mostrarDica(palavraSelecionada);
                System.out.print("Digite a palavra novamente: ");
                tentativa = scanner.nextLine();
                contador ++;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("ACERTOU!");
        System.out.println("Quantidade de erros: "+ contador);
    }

    public static void exibirMenuErro() {
        System.out.println("Errou! Escolha uma opção:");
        System.out.println("1 - Tentar novamente");
        System.out.println("2 - Pedir dica");
        System.out.print("Opção: ");
    }

    public static void mostrarDica(String palavra) {
        char primeiraLetra = palavra.charAt(0);
        char ultimaLetra = palavra.charAt(palavra.length() - 1);
        System.out.println("Dica: Primeira Letra: " + primeiraLetra);
        System.out.println("Dica: Última Letra: " + ultimaLetra);
    }
}