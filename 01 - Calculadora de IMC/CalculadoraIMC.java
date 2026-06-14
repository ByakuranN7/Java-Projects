import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CalculadoraIMC extends Application {

    @Override
    public void start(Stage palco) {

        // Etiquetas para os campos de entrada
        Label labelPeso = new Label("Peso (kg): ");
        Label labelAltura = new Label("Altura (metros): ");

        // Aumenta a fonte dos labels
        labelPeso.setStyle("-fx-font-size: 18px;");
        labelPeso.setPrefWidth(120);
        labelAltura.setStyle("-fx-font-size: 18px;");
        labelAltura.setPrefWidth(120);

        // Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        campoPeso.setPrefWidth(160);
        campoPeso.setStyle("-fx-font-size: 18px;");

        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");
        campoAltura.setPrefWidth(160);
        campoAltura.setStyle("-fx-font-size: 18px;");

        // Label para mostrar o resultado do IMC
        Label labelResultado = new Label();
        labelResultado.setStyle("-fx-font-size: 18px;");

        // Botão para calcular o IMC
        Button botaoCalcular = new Button("Calcular IMC");
        botaoCalcular.setStyle("-fx-font-size: 18px;");

        botaoCalcular.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(
                        campoPeso.getText().replace(',', '.')
                );

                double altura = Double.parseDouble(
                        campoAltura.getText().replace(',', '.')
                );

                if (peso <= 0 || altura <= 0) {
                    labelResultado.setText(
                            "Peso e altura devem ser maiores que zero."
                    );
                    return;
                }

                double imc = calculoIMC(peso, altura);

                labelResultado.setText(
                        String.format(
                                "Seu IMC é: %.2f\nSua classificação é: %s",
                                imc,
                                classificarIMC(imc)
                        )
                );

            } catch (NumberFormatException ex) {
                labelResultado.setText("Digite apenas números.");
            }
        });

        // Linha do peso
        HBox linhaPeso = new HBox(10);
        linhaPeso.getChildren().addAll(labelPeso, campoPeso);
        linhaPeso.setAlignment(Pos.CENTER_LEFT);

        // Linha da altura
        HBox linhaAltura = new HBox(10);
        linhaAltura.getChildren().addAll(labelAltura, campoAltura);
        linhaAltura.setAlignment(Pos.CENTER_LEFT);

        // Conteúdo principal
        VBox conteudo = new VBox(20);
        conteudo.getChildren().addAll(
                linhaPeso,
                linhaAltura,
                labelResultado
        );

        // Linha do botão
        HBox linhaBotao = new HBox();
        linhaBotao.getChildren().add(botaoCalcular);
        linhaBotao.setAlignment(Pos.CENTER_RIGHT);

        // Layout principal
        BorderPane layoutPrincipal = new BorderPane();

        layoutPrincipal.setCenter(conteudo);
        layoutPrincipal.setBottom(linhaBotao);

        BorderPane.setMargin(conteudo, new Insets(20));
        BorderPane.setMargin(linhaBotao, new Insets(20));

        // Cena e palco
        Scene cena = new Scene(layoutPrincipal, 500, 300);

        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }

    public double calculoIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String classificarIMC(double imc) {
        if (imc < 17) {
            return "Muito abaixo do peso.";
        } else if (imc < 18.5) {
            return "Abaixo do peso.";
        } else if (imc < 25) {
            return "Peso normal.";
        } else if (imc < 30) {
            return "Acima do peso.";
        } else if (imc < 35) {
            return "Obesidade I.";
        } else if (imc < 40) {
            return "Obesidade II (severa)";
        } else {
            return "Obesidade III (mórbida)";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}