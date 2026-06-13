//não esquecer de adicionar importações ao inserir os elementos

public class CalculadoraIMC{


    public double calculoIMC(double peso, double altura){
        return peso/(altura*altura);
    }



    public static void main(String[] args){
        double peso = 88.3; //em kg
        double altura = 1.80; //em m

        System.out.println("O IMC de uma pessoa com peso de " + peso + "kg e uma altura de " + altura "m é: " + calculoIMC(peso,altura));
    }
}