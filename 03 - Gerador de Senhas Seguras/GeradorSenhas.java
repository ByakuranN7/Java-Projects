import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorSenhas {

    private static final int TAMANHO_MINIMO = 15;

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

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int tamanho;

        do {
            System.out.print("Digite o tamanho da senha (mínimo " + TAMANHO_MINIMO + " caracteres): ");
            tamanho = scan.nextInt();

            if (tamanho < TAMANHO_MINIMO) {
                System.out.println("Erro: a senha deve possuir pelo menos " + TAMANHO_MINIMO + " caracteres.");
            }
        } while (tamanho < TAMANHO_MINIMO);

        GeradorSenhas gerador = new GeradorSenhas();
        String senha = gerador.gerarSenha(tamanho);

        System.out.println("Senha gerada: " + senha);

        scan.close();
    }
}