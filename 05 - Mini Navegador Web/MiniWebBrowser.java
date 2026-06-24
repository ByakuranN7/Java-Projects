import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;


import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;


import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MiniWebBrowser extends Application {

    @Override
    public void start(Stage palco) {
        TextField campoUrl = new TextField();
        campoUrl.setPrefWidth(700);
        Button botaoVoltar = new Button("←");
        Button botaoAvancar = new Button("→");
        Button botaoAtualizar = new Button("⟳");
        Button botaoFavorito = new Button("⭐");
        MenuButton menuFavoritos = new MenuButton("📚");
        FavoritosManager favoritosManager = new FavoritosManager();
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
        botaoFavorito.setPrefHeight(30);
        menuFavoritos.setPrefHeight(30);
        campoUrl.setPrefHeight(30);
        barraNavegacao.getChildren().addAll(botaoVoltar, botaoAvancar, botaoAtualizar, campoUrl, botaoFavorito, menuFavoritos);

        VBox layoutPrincipal = new VBox();
        layoutPrincipal.getChildren().addAll(barraNavegacao, navegador);
        VBox.setVgrow(navegador, Priority.ALWAYS);
        Scene cena = new Scene(layoutPrincipal);

        configurarBotoes(botaoVoltar, botaoAvancar, botaoAtualizar, webHistory, motor);
        configurarNavegacaoMouse(cena, webHistory);
        configurarAtalhos(cena, motor);
        configurarFavoritos(botaoFavorito, favoritosManager, motor, menuFavoritos);
        atualizarMenuFavoritos(menuFavoritos, favoritosManager, motor);

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

    public String formataUrl(String texto) {

        texto = texto.trim();

        if (texto.startsWith("http://") || texto.startsWith("https://")) {
            return texto;
        }

        if (texto.matches("^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "https://" + texto;
        }

        return "https://www.google.com/search?q=" + texto.replace(" ", "+");
    }

    private void configurarFavoritos(Button botaoFavorito, FavoritosManager favoritosManager, WebEngine motor, MenuButton menuFavoritos) {

        botaoFavorito.setOnAction(evento -> {

            String tituloAtual = motor.getTitle();
            String urlAtual = motor.getLocation();

            favoritosManager.adicionarFavorito(tituloAtual, urlAtual);
            atualizarMenuFavoritos(menuFavoritos, favoritosManager, motor);

            System.out.println(favoritosManager.getFavoritos());
        });
    }

    private void atualizarMenuFavoritos(MenuButton menuFavoritos, FavoritosManager favoritosManager, WebEngine motor) {

        menuFavoritos.getItems().clear();

        for (Favorito favorito : favoritosManager.getFavoritos()) {

            MenuItem item = new MenuItem(favorito.getTitulo());

            item.setOnAction(evento -> {
                motor.load(favorito.getUrl());
            });

            menuFavoritos.getItems().add(item);
        }
    }
    
}
