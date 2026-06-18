import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JogoDaForca {

    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        boolean jogarNovamente = true;

        while (jogarNovamente) {

            executarPartida();

            System.out.println();
            System.out.println("Deseja jogar novamente?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int opcao = scanner.nextInt();

            jogarNovamente = opcao == 1;
        }

        System.out.println("Obrigado por jogar!");
    }

    private void executarPartida() {

        GerenciadorPalavras gerenciador = new GerenciadorPalavras();

        String palavra = gerenciador.obterPalavraAleatoria();

        char[] descoberta = new char[palavra.length()];

        for (int i = 0; i < descoberta.length; i++) {
            descoberta[i] = '_';
        }

        Set<Character> letrasUtilizadas = new TreeSet<>();

        int erros = 0;
        int maxErros = 6;

        String mensagem = "";

        while (erros < maxErros) {

            System.out.println();
            DesenhoForca.desenhar(erros);

            if (!mensagem.isEmpty()) {
                System.out.println(mensagem);
                System.out.println();
            }

            System.out.print("Palavra: ");

            for (char letra : descoberta) {
                System.out.print(letra + " ");
            }

            System.out.println();

            System.out.println("Tentativas restantes: " + (maxErros - erros));

            System.out.println("Letras utilizadas: " + letrasUtilizadas);

            System.out.print("Chute uma letra: ");

            String entrada = scanner.next().toLowerCase().trim();

            if (entrada.length() != 1) {

                mensagem = "Digite apenas uma letra.";
                continue;
            }

            char chute = entrada.charAt(0);

            if (!Character.isLetter(chute)) {

                mensagem = "Digite apenas letras.";
                continue;
            }

            if (letrasUtilizadas.contains(chute)) {

                mensagem = "Você já tentou essa letra.";
                continue;
            }

            letrasUtilizadas.add(chute);

            boolean acertou = false;

            for (int i = 0; i < palavra.length(); i++) {

                if (palavra.charAt(i) == chute) {

                    descoberta[i] = chute;
                    acertou = true;
                }
            }

            if (acertou) {

                mensagem = "Você acertou a letra!";

            } else {

                erros++;
                mensagem = "Letra incorreta!";
            }

            String atual = new String(descoberta);

            if (atual.equals(palavra)) {

                System.out.println();
                DesenhoForca.desenhar(erros);

                System.out.println("Parabéns! Você acertou!");
                System.out.println("A palavra era: " + palavra);

                exibirEstatisticas(palavra, letrasUtilizadas.size(), erros, maxErros);

                return;
            }
        }

        System.out.println();
        DesenhoForca.desenhar(erros);

        System.out.println("💀 Você perdeu!");
        System.out.println("A palavra era: " + palavra);

        exibirEstatisticas(palavra, letrasUtilizadas.size(), erros, maxErros);
    }

    private void exibirEstatisticas(String palavra, int tentativas, int erros, int maxErros) {

        int acertos = tentativas - erros;

        double taxaAcerto = tentativas == 0
                ? 0
                : ((double) acertos / tentativas) * 100;

        System.out.println();
        System.out.println("===== ESTATÍSTICAS =====");

        System.out.println("Palavra: " + palavra);

        System.out.println("Acertos: " + acertos);

        System.out.println("Erros: " + erros);

        System.out.println("Tentativas restantes: " + (maxErros - erros));

        System.out.printf("Taxa de acerto: %.2f%%%n", taxaAcerto);

        System.out.println("========================");
    }
}