import java.util.Random;

public class Palavras {
    private Random random = new Random();
    private static String[] palavras = {"agua", "peixe", "mauro", "frank", "java"};
    private String palavraSelecionada;
    private String palavraEmbaralhada;

    public Palavras(){
        this.palavraSelecionada =  selecionarPalavra();
        this.palavraEmbaralhada = embaralharPalavra(this.palavraSelecionada);
    }

    private String selecionarPalavra(){
        return palavras[random.nextInt(palavras.length)];
    }

    private String embaralharPalavra(String palavra){
        char[] letras = palavra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            int j = random.nextInt(letras.length);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }
        return new String(letras);
    }

    public static String[] getPalavras() {
        return palavras;
    }

    public String getPalavraSelecionada(){
        return palavraSelecionada;
    }

    public String getPalavraEmbaralhada(){
        return palavraEmbaralhada;
    }

}
