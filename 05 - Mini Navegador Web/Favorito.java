public class Favorito {

    private String titulo;
    private String url;

    public Favorito(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return titulo + " | " + url;
    }
    
}