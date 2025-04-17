import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavras {
    private String[] palavras;
    private int tamanho = 10;
    private char[][] tabuleiro;
    private Random random;
    private Scanner scanner;

    // construtor
    public JogoCacaPalavras(String[] palavras, int tamanho) {
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.palavras = palavras;
        this.tabuleiro = new char[tamanho][tamanho];
    }

    public void iniciar() {
        String palavraSelecionada = palavras[random.nextInt(palavras.length)];
        colocarPalavra(palavraSelecionada);
        preencherTabuleiro();
        imprimirTabuleiro();
        verificarPalavra(palavraSelecionada);
    }

    private void colocarPalavra(String palavra) {
        boolean colocada = false;
        while (!colocada) {
            int direcao = random.nextInt(3);
            int linha = 0, coluna = 0;

            if (direcao == 0) {
                linha = random.nextInt(tamanho);
                coluna = random.nextInt(tamanho - palavra.length());
            } else if (direcao == 1) {
                linha = random.nextInt(tamanho - palavra.length());
                coluna = random.nextInt(tamanho);
            } else {
                linha = random.nextInt(tamanho - palavra.length());
                coluna = random.nextInt(tamanho - palavra.length());
            }

            boolean podeColocar = true;
            for (int i = 0; i < palavra.length(); i++) {
                int l = linha;
                int c = coluna;

                if (direcao == 0) { // Horizontal
                    c += i;
                } else if (direcao == 1) { // Vertical
                    l += i;
                } else { // Diagonal
                    l += i;
                    c += i;
                }
                if (tabuleiro[l][c] != 0 && tabuleiro[l][c] != palavra.charAt(i)) {
                    podeColocar = false;
                    break;
                }
            }

            if (podeColocar) {
                for (int i = 0; i < palavra.length(); i++) {
                    int l = linha;
                    int c = coluna;

                    if (direcao == 0) { // Horizontal
                        c += i;
                    } else if (direcao == 1) { // Vertical
                        l += i;
                    } else if (direcao == 2) { // Diagonal
                        l += i;
                        c += i;
                    }
                    tabuleiro[l][c] = palavra.charAt(i);
                }
                colocada = true;
            }
        }
    }

    private void preencherTabuleiro() {
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                if (tabuleiro[x][y] == 0) {
                    tabuleiro[x][y] = (char) ('a' + random.nextInt(26));
                }
            }
        }
    }

    private void imprimirTabuleiro() {
        System.out.println("==== CAÇA PALAVRAS ====");
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println();
        }
    }

    private void verificarPalavra(String palavraSelecionada) {
        String tentativa = UtilJogo.lerPalavra(scanner);

        while (!tentativa.equalsIgnoreCase(palavraSelecionada)) {
            UtilJogo.exibirMenu();
            String escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                tentativa = UtilJogo.lerPalavra(scanner);
            } else if (escolha.equals("2")) {
                UtilJogo.mostrarDica(palavraSelecionada);
                tentativa = UtilJogo.lerPalavra(scanner);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("ACERTOU!");
    }
}