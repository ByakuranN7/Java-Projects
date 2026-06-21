
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MiniWebBrowser extends Application {

    @Override
    public void start(Stage palco) {
        TextField campoUrl = new TextField();
        Button botaoAtualizar = new Button("Atualizar");
        WebView navegador = new WebView();
        WebEngine motor = navegador.getEngine();
        motor.load("https://www.google.com/");

        // Carregar uma página da web quando o usuário pressiona Enter
        campoUrl.setOnAction(evento -> motor.load(formataUrl(campoUrl.getText())));

        botaoAtualizar.setOnAction(evento -> motor.reload());

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.getChildren().addAll(botaoAtualizar, campoUrl, navegador);
        Scene cena = new Scene(layoutPrincipal);

        cena.setOnKeyPressed(evento -> {
            if (evento.getCode() == KeyCode.F5) {
                motor.reload();
            }
        });

        palco.setTitle("Meu Browser Java");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
// Método para inserir http se o usuário não digitar
    public String formataUrl (String url){
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }
}
