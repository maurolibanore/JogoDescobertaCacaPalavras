import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vetor com palavras que podem ser usadas nos jogos
        String[] palavras = {"agua", "peixe", "mauro", "frank"};

        // Exibe o menu de escolha do jogo
        System.out.println("Escolha o jogo:");
        System.out.println("1 - Jogo da Descoberta");
        System.out.println("2 - Caça-Palavras");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt(); // Lê a opção escolhida
        scanner.nextLine(); // Limpa o Enter deixado pelo nextInt

        // Chama o jogo correspondente
        if (opcao == 1) {
            JogoCacaPalavras jogo1 = new JogoCacaPalavras(palavras);
            jogo1.iniciar();
        } else {
            //JogoCacaPalavras jogo2 = new JogoCacaPalavras(palavras, 10);
            //jogo2.iniciar();
        }
    }
}