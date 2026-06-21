
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory;

public class MiniWebBrowser extends Application {

    @Override
    public void start(Stage palco) {
        TextField campoUrl = new TextField();
        Button botaoVoltar = new Button("←");
        Button botaoAtualizar = new Button("Atualizar");
        WebView navegador = new WebView();
        WebEngine motor = navegador.getEngine();
        WebHistory webHistory = motor.getHistory();
        motor.load("https://www.google.com/");

        // Carregar uma página da web quando o usuário pressiona Enter
        campoUrl.setOnAction(evento -> motor.load(formataUrl(campoUrl.getText())));

        botaoAtualizar.setOnAction(evento -> motor.reload());
        botaoVoltar.setOnAction(evento -> {
            if (webHistory.getCurrentIndex() > 0) {
                webHistory.go(-1);
            }
        });

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.getChildren().addAll(botaoVoltar, botaoAtualizar, campoUrl, navegador);
        Scene cena = new Scene(layoutPrincipal);

        cena.setOnMousePressed(evento -> {
            if (evento.getButton() == MouseButton.BACK) {
                if (webHistory.getCurrentIndex() > 0) {
                    webHistory.go(-1);
                }
            }
        });

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
