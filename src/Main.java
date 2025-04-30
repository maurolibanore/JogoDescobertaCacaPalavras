import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] palavras = UtilJogo.getPalavras();

        boolean jogarNovamente = true;
        while (jogarNovamente) {
            // Exibe o menu de escolha do jogo
            System.out.println("== Escolha o jogo: ==");
            System.out.println("== 1 - Jogo da Descoberta ==");
            System.out.println("== 2 - Caça-Palavras ==");
            System.out.print("== Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();


            if (opcao == 1) {
                Descoberta descoberta = new Descoberta(palavras);
                descoberta.iniciar();
            } else if (opcao == 2) {
                JogoCacaPalavras cacaPalavras = new JogoCacaPalavras(palavras, 10);
                cacaPalavras.iniciar();
            } else {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            System.out.print("Você deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                jogarNovamente = false;
            }
        }

        System.out.println("Fim de Jogo!");
    }
}