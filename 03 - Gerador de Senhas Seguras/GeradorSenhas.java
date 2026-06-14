import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorSenhas{

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

        System.out.print("Digite o tamanho da senha: ");
        int tamanho = scan.nextInt();

        GeradorSenhas gerador = new GeradorSenhas();

        String senha = gerador.gerarSenha(tamanho);

        System.out.println("Senha gerada: " + senha);

        scan.close();
    }
}