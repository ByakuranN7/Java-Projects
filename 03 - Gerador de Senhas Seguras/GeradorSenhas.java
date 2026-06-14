import java.security.SecureRandom;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class GeradorSenhas extends Application{

    private static final int TAMANHO_MINIMO = 15;

    @Override
    public void start (Stage palco){

        Label messageLabel = new Label("Digite o tamanho da senha (minimo " + TAMANHO_MINIMO + "): ");
        messageLabel.setStyle("-fx-font-size: 24px;");

        TextField campoTamanho = new TextField();
        campoTamanho.setPromptText("Tamanho da senha");
        campoTamanho.setPrefWidth(160);
        campoTamanho.setStyle("-fx-font-size: 24px;");

        Label resultadoLabel = new Label();
        resultadoLabel.setStyle("-fx-font-size: 18px;");

        // Botão para calcular o IMC
        Button botaoGerador = new Button("Gerar Senha");
        botaoGerador.setStyle("-fx-font-size: 24px;");

        botaoGerador.setOnAction(e -> {
            try {
                int tamanho = Integer.parseInt(campoTamanho.getText());

                if (tamanho < TAMANHO_MINIMO) {
                    resultadoLabel.setText("A senha deve possuir pelo menos " + TAMANHO_MINIMO + " caracteres.");
                    return;
                }

                String senhaGerada = gerarSenha(tamanho);
                resultadoLabel.setText(senhaGerada);

            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Digite apenas números.");
            }
        });

        VBox layout = new VBox(20);

        layout.getChildren().addAll(messageLabel, campoTamanho, botaoGerador, resultadoLabel);

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene cena = new Scene(layout, 700, 300);

        palco.setTitle("Gerador de Senhas");
        palco.setScene(cena);
        palco.show();
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

    public static void main(String[] args) {
        launch(args);
    }
}