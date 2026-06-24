import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FavoritosManager {

    private ArrayList<Favorito> favoritosList;

    public FavoritosManager() {
        favoritosList = carregarFavoritos();
    }

    public void adicionarFavorito(String titulo, String url) {

        for (Favorito favorito : favoritosList) {
            if (favorito.getUrl().equals(url)) {
                return;
            }
        }

        Favorito favorito = new Favorito(titulo, url);
        favoritosList.add(favorito);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("favoritos.txt", true))) {

            writer.write(titulo + "|" + url);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Favorito> getFavoritos() {
        return favoritosList;
    }

    private ArrayList<Favorito> carregarFavoritos() {

        ArrayList<Favorito> favoritosCarregados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("favoritos.txt"))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split("\\|");

                if (partes.length == 2) {

                    String titulo = partes[0];
                    String url = partes[1];

                    favoritosCarregados.add(new Favorito(titulo, url));
                }
            }

        } catch (IOException e) {
            System.out.println("Arquivo de favoritos não encontrado.");
        }

        return favoritosCarregados;
    }
}