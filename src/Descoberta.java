import java.util.Random;
import java.util.Scanner;

public class Descoberta {
    private Scanner scanner;
    private Random random;
    private String[] palavras;
    private String palavraSelecionada;
    private String palavraEmbaralhada;
    private int contador;

    // construtor
    public Descoberta(String[] palavras) {
        this.palavras = palavras;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.palavraSelecionada = palavras[random.nextInt(palavras.length)];
        this.palavraEmbaralhada = embaralharPalavra(palavraSelecionada);
    }

    private String embaralharPalavra(String palavra) {
        char[] letras = palavra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            int j = random.nextInt(letras.length);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }
        return new String(letras);
    }

    public void iniciar() {
        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
        String tentativa = UtilJogo.lerPalavra(scanner);

        while (!tentativa.equalsIgnoreCase(palavraSelecionada)) {  // ignore case para ignorar maiusc ou min
            UtilJogo.exibirMenuErro();
            String escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                tentativa = UtilJogo.lerPalavra(scanner);
                contador++;
            } else if (escolha.equals("2")) {
                UtilJogo.mostrarDica(palavraSelecionada);
                tentativa = UtilJogo.lerPalavra(scanner);
                contador++;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("ACERTOU!");
        System.out.println("Quantidade de erros: " + contador);
    }
}