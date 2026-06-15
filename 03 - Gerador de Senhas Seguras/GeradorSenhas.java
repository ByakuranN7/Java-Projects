import java.security.SecureRandom;

public class GeradorSenhas{

    private static final int TAMANHO_MINIMO = 15;

    public static int getTamanhoMinimo() {
        return TAMANHO_MINIMO;
    }

    public String gerarSenha(int tamanho) {

        String caracteres =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "abcdefghijklmnopqrstuvwxyz" +
                        "0123456789" +
                        "!@#$%&*()-_=+";

        SecureRandom secRandom = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {

            int indice = secRandom.nextInt(caracteres.length());
            senha.append(caracteres.charAt(indice));
        }
        return senha.toString();
    }

}