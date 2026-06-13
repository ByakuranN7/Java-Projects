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
        Label labelPeso = new Label("Peso");
        Label labelAltura = new Label("Altura");

        // Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");

        // Label para mostrar o resultado do IMC
        Label labelResultado = new Label();

        // Botão para calcular o IMC
        Button botaoCalcular = new Button("Calcular IMC"); //preciso configurar a ação do botão

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

    public static void classificarIMC(double imc){
        if (imc < 17) {
            System.out.println("\nMuito abaixo do peso.");
        } else if (imc < 18.5) {
            System.out.println("\nAbaixo do peso.");
        } else if (imc < 25) {
            System.out.println("\nPeso normal.");
        } else if (imc < 30) {
            System.out.println("\nAcima do peso.");
        } else if (imc < 35) {
            System.out.println("\nObesidade I.");
        } else if (imc < 40) {
            System.out.println("\nObesidade II (severa)");
        } else {
            System.out.println("\nObesidade III (mórbida)");
        }
    }

    public static void main(String[] args) {
        launch(args);
        //double peso = 75.3; //em kg
        //double altura = 1.80; //em m
        //double imc;

        //imc = calculoIMC(peso, altura);

        //System.out.println("O IMC de uma pessoa com peso de " + peso + "kg e uma altura de " + altura + "m é: " + imc);
        //classificarIMC(imc);
    }

}