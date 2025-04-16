import java.util.Random;
import java.util.Scanner;

public class JogoCacaPalavras {
    private String[] palavras;
    private int tamanho = 10;
    private char[][] tabuleiro;
    private Random random;
    private Scanner scanner;

    // Construtor
    public JogoCacaPalavras(String[] palavras, int tamanho) {
        this.palavras = palavras;
        this.tabuleiro = new char[tamanho][tamanho];
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        String palavraSelecionada = selecionarPalavra(palavras);
        preencherTabuleiro(tabuleiro, tamanho);
        colocarPalavra(tabuleiro, tamanho, palavraSelecionada);
        imprimirTabuleiro(tabuleiro, tamanho);
        verificarPalavra(palavraSelecionada);
    }

    private static String selecionarPalavra(String vetor[]) {

        return  vetor[new Random().nextInt(vetor.length)];
    }


    private static void preencherTabuleiro(char tabuleiro[][], int tamanho) {
        Random random = new Random(); // PRIMEIRO Random - Classe - random - objeto - Random() Construtor
        for (int x = 0; x < tamanho; x++) {        // PADRAO DO LACO DE REPETICAO
            for (int y = 0; y < tamanho; y++) {       // DOIS LAÇOS - UM PARA A LINHA OUTRO COLUNA POIS E UMA MATRIZ
                tabuleiro[x][y] = (char) ('a' + random.nextInt(25));     // faz os SORTEIOS PELA TABELA ASCII de 0 ate 25 a partir do 'a'
            }
        }
    }

    private static void colocarPalavra(char tabuleiro[][], int tamanho, String palavraSelecionada){
        Random random = new Random();
        int linha = random.nextInt(tamanho);
        int coluna = random.nextInt(tamanho - palavraSelecionada.length());  // para nao dar divergencia no final da coluna

        for (int x = 0; x <palavraSelecionada.length(); x++) {
            tabuleiro[linha][coluna+x] = palavraSelecionada.charAt(x);  // CHATAT pega o char por palavra ex mauro chatat 0 = m
        }
    }

    private static void imprimirTabuleiro(char tabuleiro[][], int tamanho) {  // cria uma classe privada para melhor organizacao
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println("");
        }
    }

    private static void verificarPalavra(String palavraSelecionada){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a palavra: ");
        String opcao = scanner.nextLine();

        while (!opcao.equals(palavraSelecionada)) {
            // Se errar, mostra a dica
            char primeiraLetra = palavraSelecionada.charAt(0);
            char ultimaLetra = palavraSelecionada.charAt(palavraSelecionada.length() - 1);

            System.out.println("Errou! Tente novamente.");
            System.out.println("Dica: Primeira Letra: " + primeiraLetra);
            System.out.println("Dica: Última Letra: " + ultimaLetra);
            System.out.print("Qual a palavra: ");
            opcao = scanner.nextLine(); // Lê novamente
        }
        System.out.println("ACERTOU!");
    }
}