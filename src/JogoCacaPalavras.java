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
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.palavras = palavras;
        this.tabuleiro = new char[tamanho][tamanho];
    }

    public void iniciar() {
        String palavraSelecionada = escolherPalavra(palavras);
        colocarPalavra(tabuleiro, tamanho, palavraSelecionada);
        preencherTabuleiro(tabuleiro, tamanho);
        imprimirTabuleiro(tabuleiro, tamanho);
        verificarPalavra(palavraSelecionada);
    }

    private static String escolherPalavra(String palavras[]) {
        return  palavras[new Random().nextInt(palavras.length)];
    }


    private static void preencherTabuleiro(char tabuleiro[][], int tamanho) {
        Random random = new Random();
        for (int x = 0; x < tamanho; x++) {
            for (int y = 0; y < tamanho; y++) {
                if (tabuleiro[x][y] == 0) { // Só preenche se estiver vazio
                    tabuleiro[x][y] = (char) ('a' + random.nextInt(26)); // letras de a até z da tabela ASSCI
                }
            }
        }
    }

    private static void colocarPalavra(char[][] tabuleiro, int tamanho, String palavraSelecionada) {
        Random random = new Random();
        boolean colocada = false;
        while (!colocada) {

            int direcao = random.nextInt(3);// 0 = horizontal, 1 = vertical, 2 = diagonal

            int linha = 0;
            int coluna = 0;

            if (direcao == 0) { // Horizontal
                linha = random.nextInt(tamanho);
                coluna = random.nextInt(tamanho - palavraSelecionada.length());
            } else if (direcao == 1) { // Vertical
                linha = random.nextInt(tamanho - palavraSelecionada.length());
                coluna = random.nextInt(tamanho);
            } else { // Diagonal
                linha = random.nextInt(tamanho - palavraSelecionada.length());
                coluna = random.nextInt(tamanho - palavraSelecionada.length());
            }

            // Inicializa uma variável para verificar se a palavra pode ser colocada na posição sorteada
            boolean podeColocar = true;

            for (int i = 0; i < palavraSelecionada.length(); i++) {
                int l = linha;
                int c = coluna;

                if (direcao == 0) { // horizontal
                    c += i;
                } else if (direcao == 1) { // vertical
                    l += i;
                } else if (direcao == 2) { // diagonal
                    l += i;
                    c += i;
                }

                // Verifica se o espaço já está ocupado por outra letra diferente
                // Se estiver ocupado com uma letra diferente, não pode colocar a palavra aqui
                if (tabuleiro[l][c] != 0 && tabuleiro[l][c] != palavraSelecionada.charAt(i)) {
                    podeColocar = false;
                    break;
                }
            }

            if (podeColocar) {
                // Laço novamente para realmente colocar as letras da palavra no tabuleiro
                for (int i = 0; i < palavraSelecionada.length(); i++) {
                    int l = linha + (direcao == 1 || direcao == 2 ? i : 0);// Calcula a linha onde a letra será posicionada
                    int c = coluna + (direcao == 0 || direcao == 2 ? i : 0);// Calcula a coluna onde a letra será posicionada
                    tabuleiro[l][c] = palavraSelecionada.charAt(i);// Coloca a letra da palavra no tabuleiro na posição calculada
                }
                colocada = true;
            }
        }
    }

    private static void imprimirTabuleiro(char tabuleiro[][], int tamanho) {  // cria uma classe privada para melhor organizacao
        System.out.println("==== CAÇA PALAVRAS ====");
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