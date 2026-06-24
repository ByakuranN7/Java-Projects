import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FavoritosManager {

    private ArrayList<String> favoritos;

    public FavoritosManager() {
        favoritos = carregarFavoritos();
    }

    public void adicionarFavorito(String url) {

        if (!favoritos.contains(url)) {

            favoritos.add(url);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("favoritos.txt", true))) {

                writer.write(url);
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> getFavoritos() {
        return favoritos;
    }

    private ArrayList<String> carregarFavoritos() {

        ArrayList<String> favoritosCarregados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("favoritos.txt"))) {

            String linha;

            while ((linha = reader.readLine()) != null) {
                favoritosCarregados.add(linha);
            }

        } catch (IOException e) {
            System.out.println("Arquivo de favoritos não encontrado.");
        }

        return favoritosCarregados;
    }
}