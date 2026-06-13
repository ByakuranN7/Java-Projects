//não esquecer de adicionar importações ao inserir os elementos

public class CalculadoraIMC {


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
        double peso = 75.3; //em kg
        double altura = 1.80; //em m
        double imc;

        imc = calculoIMC(peso, altura);

        System.out.println("O IMC de uma pessoa com peso de " + peso + "kg e uma altura de " + altura + "m é: " + imc);
        classificarIMC(imc);
    }

}