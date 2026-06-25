import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintWriter;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;




public class EditorTexto extends Application{

    @Override
    public void start(Stage palco){

        TextArea areaTexto = new TextArea();

        Button botaoSalvar = new Button("Salvar");
        botaoSalvar.setOnAction(e -> salvarTexto(areaTexto));

        //Barra de ferraments com o botão para salvar
        ToolBar barraDeFerramentas = new ToolBar(botaoSalvar);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(barraDeFerramentas);
        borderPane.setCenter(areaTexto);

        //Vbox vBox = new Vbox(botaoSalvar, areaTexto);
        //vBox.setSpacing(10); // Configura espaçamento entre os componentes
        //vBox.setPadding(new Insets(10)); // Adiciona um espaçamento de 10 pixels em todas as bordas


        Scene cena = new Scene(borderPane, 800, 600);
        palco.setTitle("Editor de Texto");
        palco.setScene(cena);
        palco.show();
    }

    public void salvarTexto(TextArea textArea){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo de Texto");
        File file = fileChooser.showSaveDialog(null);
        if(file != null){
            try (PrintWriter writer = new PrintWriter(file)){
                writer.println(textArea.getText());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}