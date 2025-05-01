import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavras {
    private char[][] tabuleiro;
    private Random random;
    private Scanner scanner;
    private Palavras palavras;
    private String palavraSelecionada;
    private int tamanho;


    // construtor
    public JogoCacaPalavras(String[] palavras) {
        random = new Random();
        scanner = new Scanner(System.in);
        this.palavras = new Palavras();
        this.tamanho = UtilJogo.getTamanhoTabuleiro();
        this.tabuleiro = new char[tamanho][tamanho];
    }


    public void iniciar() {
        this.palavraSelecionada = palavras.getPalavraSelecionada();
        colocarPalavra(palavraSelecionada);
        preencherTabuleiro();
        imprimirTabuleiro();
        UtilJogo.verificarPalavra(palavraSelecionada, scanner);
    }

    private void colocarPalavra(String palavraSelecionada) {
        Random random = new Random();

        int linha = random.nextInt(tamanho);
        int coluna = random.nextInt(tamanho - palavraSelecionada.length());  // para nao dar divergencia no final da coluna

        for (int x = 0; x <palavraSelecionada.length(); x++)
            tabuleiro[linha][coluna + x] = palavraSelecionada.charAt(x);  // CHATAT pega o char por palavra ex mauro chatat 0 = m
    }

    private void preencherTabuleiro() {
        int tamanho = UtilJogo.getTamanhoTabuleiro();
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                if (tabuleiro[x][y] == 0) {
                    tabuleiro[x][y] = (char) ('a' + random.nextInt(26));
                }
            }
        }
    }

    private void imprimirTabuleiro() {
        int tamanho = UtilJogo.getTamanhoTabuleiro();
        System.out.println("==== CAÇA PALAVRAS ====");
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println();
        }
    }



}