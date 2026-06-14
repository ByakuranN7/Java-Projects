import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RelogioDigital extends Application {

    @Override
    public void start(Stage palco) {

        // Título do relógio principal
        Label labelCidadeBrasil = new Label("São Paulo (Brasil)");
        labelCidadeBrasil.setStyle("-fx-font-size: 24px;");

        // Horário principal
        Label labelHoraBrasil = new Label();
        labelHoraBrasil.setStyle("-fx-font-size: 62px;" + "-fx-font-weight: bold;");

        // Outros países
        Label labelEUA = new Label();
        Label labelFranca = new Label();
        Label labelReinoUnido = new Label();
        Label labelAlemanha = new Label();
        Label labelJapao = new Label();
        Label labelChina = new Label();

        labelEUA.setStyle("-fx-font-size: 18px;");
        labelFranca.setStyle("-fx-font-size: 18px;");
        labelReinoUnido.setStyle("-fx-font-size: 18px;");
        labelAlemanha.setStyle("-fx-font-size: 18px;");
        labelJapao.setStyle("-fx-font-size: 18px;");
        labelChina.setStyle("-fx-font-size: 18px;");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");

        atualizarRelogios(
                labelHoraBrasil,
                labelEUA,
                labelFranca,
                labelReinoUnido,
                labelAlemanha,
                labelJapao,
                labelChina,
                formatador
        );

        // Timeline = Executa algo em um intervalo específico de tempo
        // KeyFrame = Define o que acontece em cada intervalo
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> atualizarRelogios(
                                labelHoraBrasil,
                                labelEUA,
                                labelFranca,
                                labelReinoUnido,
                                labelAlemanha,
                                labelJapao,
                                labelChina,
                                formatador
                        )));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Topo
        VBox topo = new VBox(10);
        topo.getChildren().addAll(labelCidadeBrasil, labelHoraBrasil);
        topo.setAlignment(Pos.CENTER);

        // Coluna esquerda
        VBox colunaEsquerda = new VBox(10);
        colunaEsquerda.getChildren().addAll(
                labelEUA,
                labelFranca,
                labelReinoUnido
        );

        // Coluna direita
        VBox colunaDireita = new VBox(10);
        colunaDireita.getChildren().addAll(
                labelAlemanha,
                labelJapao,
                labelChina
        );

        colunaEsquerda.setAlignment(Pos.CENTER_LEFT);
        colunaDireita.setAlignment(Pos.CENTER_LEFT);

        // Relógios mundiais
        HBox relogiosMundiais = new HBox(80);
        relogiosMundiais.getChildren().addAll(colunaEsquerda, colunaDireita);
        relogiosMundiais.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();

        layout.setTop(topo);
        layout.setCenter(relogiosMundiais);

        BorderPane.setMargin(topo, new Insets(20));

        BorderPane.setMargin(relogiosMundiais, new Insets(20));

        Scene cena = new Scene(layout, 600, 300);

        palco.setTitle("Relógio Mundial");
        palco.setScene(cena);
        palco.show();
    }

    private void atualizarRelogios(
            Label labelHoraBrasil,
            Label labelEUA,
            Label labelFranca,
            Label labelReinoUnido,
            Label labelAlemanha,
            Label labelJapao,
            Label labelChina,
            DateTimeFormatter formatador
    ) {
        
        labelHoraBrasil.setText(obterHora("America/Sao_Paulo", formatador));
        labelEUA.setText("Nova York (EUA): " + obterHora("America/New_York", formatador));
        labelFranca.setText("Paris (França): " + obterHora("Europe/Paris", formatador));
        labelReinoUnido.setText("Londres (Reino Unido): " + obterHora("Europe/London", formatador));
        labelAlemanha.setText("Berlim (Alemanha): " + obterHora("Europe/Berlin", formatador));
        labelJapao.setText("Tóquio (Japão): " + obterHora("Asia/Tokyo", formatador));
        labelChina.setText("Pequim (China): " + obterHora("Asia/Shanghai", formatador));
    }

    private String obterHora(String zoneId, DateTimeFormatter formatador) {
        return ZonedDateTime.now(ZoneId.of(zoneId)).format(formatador);
    }

    public static void main(String[] args) {
        launch(args);
    }
}