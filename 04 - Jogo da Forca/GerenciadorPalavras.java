import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GerenciadorPalavras {

    private static final String CAMINHO_ARQUIVO = "resources/palavras.txt";

    public String obterPalavraAleatoria() {

        try {

            List<String> palavras = Files.readAllLines(Paths.get(CAMINHO_ARQUIVO));

            Random random = new Random();

            return palavras.get(random.nextInt(palavras.size())).toLowerCase();

        } catch (IOException e) {

            System.out.println("Erro ao carregar palavras.");
            return "java";

        }
    }
}