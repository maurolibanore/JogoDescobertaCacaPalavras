import java.util.Scanner;

public class UtilJogo {
    public static String lerPalavra(Scanner scanner) {
        System.out.print("Qual a palavra: ");
        return scanner.nextLine();
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