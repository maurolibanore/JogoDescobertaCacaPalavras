import java.util.Random;
import java.util.Scanner;

public class Descoberta {
    private Scanner scanner;
    private Random random;
    private Palavras palavras;
    protected int contador;

    // construtor
    public Descoberta(String[] palavras) {
        random = new Random();
        scanner = new Scanner(System.in);
        this.palavras = new Palavras();
    }


    public void iniciar() {
        String palavraSelecionada = palavras.getPalavraSelecionada();
        String palavraEmbaralhada = palavras.getPalavraEmbaralhada();

        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);

        UtilJogo.verificarPalavra(palavraSelecionada, scanner);
    }
}