import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CalculadoraIMC extends Application{

    @Override
    public void start(Stage palco) {
        // Etiquetas para os campos de entrada
        Label labelPeso = new Label("Peso (kg)");
        Label labelAltura = new Label("Altura (metros)");

        // Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");

        // Label para mostrar o resultado do IMC
        Label labelResultado = new Label();

        // Botão para calcular o IMC
        Button botaoCalcular = new Button("Calcular IMC");
        botaoCalcular.setOnAction(e -> {
            double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
            double altura = Double.parseDouble(campoAltura.getText().replace(',', '.'));

            double imc = calculoIMC(peso, altura);

            labelResultado.setText(String.format("Seu IMC é: %.2f e sua classificação é: %s", imc, classificarIMC(imc)));
        });

        // Layout vertical
        VBox layout = new VBox(10, labelPeso, campoPeso, labelAltura, campoAltura, botaoCalcular, labelResultado);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        // Cena e palco
        Scene cena = new Scene(layout, 350, 250);
        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }


    public static double calculoIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc){
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