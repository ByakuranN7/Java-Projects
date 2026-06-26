import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListaDeCompras extends Application{
    private ArrayList<String> listaDeCompras = new ArrayList<>();
    private ListView<String> listaVisualizavel = new ListView<>(); //Utilizada para exibir os itens da lista de compras

    @Override
    public void start(Stage palco){
        palco.setTitle("Lista de Compras");

        TextField textFieldDescricaoItem = new TextField();
        Button botaoAdicionar = new Button("Adicionar Item");
        Button botaoExportar = new Button("Exportar Lista");

        Label labelAdicionar = new Label("Digite o item que deseja adicionar:");
        Label labelListaDeCompras = new Label("Lista de Compras:");

        //Criação do objeto ObservableList a partir da listaDeCompras, vai ficar observando a lista para atualizar quando mudar
        ObservableList<String> observableListaDeCompras = FXCollections.observableArrayList(listaDeCompras);
        listaVisualizavel.setItems(observableListaDeCompras);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(labelAdicionar, textFieldDescricaoItem, botaoAdicionar, labelListaDeCompras, listaVisualizavel, botaoExportar);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));


        botaoAdicionar.setOnAction(e -> {
           String item = textFieldDescricaoItem.getText();
           if(!item.isEmpty()){
               listaDeCompras.add(item);
               listaVisualizavel.getItems().add(item);
               textFieldDescricaoItem.clear();
           }
        });

        botaoExportar.setOnAction(e -> {
            try{
                File arquivo = new File("listaDeCompras.txt");
                PrintWriter writer = new PrintWriter(arquivo);
                for(String item : listaDeCompras){
                    writer.println(item);
                }
                writer.close();
            } catch (Exception ex){
                System.out.println("Erro: " + ex.getMessage());
            }
        });

        Scene cena = new Scene(vbox, 350, 300);
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}