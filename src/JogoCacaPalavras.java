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
        String palavraSelecionada = selecionarPalavra(palavras, palavras);
        preencherTabuleiro(tabuleiro, tamanho);
        colocarPalavra(tabuleiro, tamanho, palavraSelecionada);
        imprimirTabuleiro(tabuleiro, tamanho);
        verificarPalavra(palavraSelecionada);
    }

    private static String selecionarPalavra(String vetor[], String vetor2[]) {
        return  vetor[new Random().nextInt(vetor.length)];
    }


    private static void preencherTabuleiro(char tabuleiro[][], int tamanho) {
        Random random = new Random();
        for (int x = 0; x < tamanho; x++) {        // PADRAO DO LACO DE REPETICAO
            for (int y = 0; y < tamanho; y++) {       // DOIS LAÇOS - UM PARA A LINHA OUTRO COLUNA POIS E UMA MATRIZ
                tabuleiro[x][y] = (char) ('a' + random.nextInt(25));     // faz os SORTEIOS PELA TABELA ASCII de 0 ate 25 a partir do 'a'
            }
        }
    }

    private static void colocarPalavra(char[][] tabuleiro, int tamanho, String palavraSelecionada) {
        Random random = new Random();
        boolean colocada = false;
        while (!colocada) {
            // 0 = horizontal, 1 = vertical, 2 = diagonal
            int direcao = random.nextInt(3);

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

                // Calcula a linha onde a letra será posicionada, com base na direção:
                // direção 1 (vertical) ou 2 (diagonal) -> soma i à linha
                int r = linha + (direcao == 1 || direcao == 2 ? i : 0);

                // Calcula a coluna onde a letra será posicionada, com base na direção:
                // direção 0 (horizontal) ou 2 (diagonal) -> soma i à coluna
                int c = coluna + (direcao == 0 || direcao == 2 ? i : 0);

                // Verifica se o espaço já está ocupado por outra letra diferente
                // Se estiver ocupado com uma letra diferente, não pode colocar a palavra aqui
                if (tabuleiro[r][c] != 0 && tabuleiro[r][c] != palavraSelecionada.charAt(i)) {
                    podeColocar = false; // Marca que não pode colocar
                    break;               // Sai do laço, não precisa mais verificar o restante
                }
            }

            if (podeColocar) {
                // Laço novamente para realmente colocar as letras da palavra no tabuleiro
                for (int i = 0; i < palavraSelecionada.length(); i++) {

                    // Calcula a linha onde a letra será posicionada
                    int r = linha + (direcao == 1 || direcao == 2 ? i : 0);

                    // Calcula a coluna onde a letra será posicionada
                    int c = coluna + (direcao == 0 || direcao == 2 ? i : 0);

                    // Coloca a letra da palavra no tabuleiro na posição calculada
                    tabuleiro[r][c] = palavraSelecionada.charAt(i);
                }

                // Marca que a palavra foi colocada com sucesso, para encerrar o loop externo
                colocada = true;
            }
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