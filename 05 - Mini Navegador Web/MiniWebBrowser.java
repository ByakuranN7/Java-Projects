
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        campoUrl.setPrefWidth(700);
        Button botaoVoltar = new Button("←");
        Button botaoAvancar = new Button("→");
        Button botaoAtualizar = new Button("⟳");
        WebView navegador = new WebView();
        WebEngine motor = navegador.getEngine();
        WebHistory webHistory = motor.getHistory();

        motor.locationProperty().addListener((observable, urlAntiga, urlNova) -> {
            campoUrl.setText(urlNova);
        });
        
        motor.load("https://www.google.com/");

        // Carregar uma página da web quando o usuário pressiona Enter
        campoUrl.setOnAction(evento -> motor.load(formataUrl(campoUrl.getText())));


        HBox barraNavegacao = new HBox();
        barraNavegacao.setSpacing(10);
        botaoVoltar.setPrefHeight(30);
        botaoAvancar.setPrefHeight(30);
        botaoAtualizar.setPrefHeight(30);
        campoUrl.setPrefHeight(30);
        barraNavegacao.getChildren().addAll(botaoVoltar, botaoAvancar, botaoAtualizar, campoUrl);

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.getChildren().addAll(barraNavegacao, navegador);
        VBox.setVgrow(navegador, Priority.ALWAYS);
        Scene cena = new Scene(layoutPrincipal);

        configurarBotoes(botaoVoltar, botaoAvancar, botaoAtualizar, webHistory, motor);
        configurarNavegacaoMouse(cena, webHistory);
        configurarAtalhos(cena, motor);

        palco.setTitle("Meu Browser Java");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void configurarAtalhos(Scene cena, WebEngine motor) {
        cena.setOnKeyPressed(evento -> {
            if (evento.getCode() == KeyCode.F5) {
                motor.reload();
            }
        });
    }

    private void configurarNavegacaoMouse(Scene cena, WebHistory webHistory) {
        cena.setOnMousePressed(evento -> {

            if (evento.getButton() == MouseButton.BACK) {
                if (webHistory.getCurrentIndex() > 0) {
                    webHistory.go(-1);
                }
            }

            if (evento.getButton() == MouseButton.FORWARD) {
                if (webHistory.getCurrentIndex() < webHistory.getEntries().size() - 1) {
                    webHistory.go(1);
                }
            }

        });
    }

    private void configurarBotoes(Button botaoVoltar, Button botaoAvancar, Button botaoAtualizar, WebHistory webHistory, WebEngine motor) {

        botaoAtualizar.setOnAction(evento -> motor.reload());

        botaoVoltar.setOnAction(evento -> {
            if (webHistory.getCurrentIndex() > 0) {
                webHistory.go(-1);
            }
        });

        botaoAvancar.setOnAction(evento -> {
            if (webHistory.getCurrentIndex() < webHistory.getEntries().size() - 1) {
                webHistory.go(1);
            }
        });
    }
    
// Método para inserir http se o usuário não digitar
    public String formataUrl (String url){
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }
}
