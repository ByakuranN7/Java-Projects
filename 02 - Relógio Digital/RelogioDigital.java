import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelogioDigital extends Application {

    @Override
    public void start(Stage palco) {

        Label labelHora = new Label();
        labelHora.setStyle("-fx-font-size: 40px;");

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
        atualizarRelogio(labelHora, formatador); //evita ter que esperar 1s antes de ver o primeiro horario

        //Timeline = Executa algo em um intervalo especifico de tempo, keyframe = Define o que acontece em cada intervalo.
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    atualizarRelogio(labelHora, formatador);
                }));

        timeline.setCycleCount(
                Timeline.INDEFINITE
        );

        timeline.play();

        StackPane layout = new StackPane(labelHora);

        Scene cena = new Scene(layout, 300, 150);

        palco.setTitle("Relógio Digital");
        palco.setScene(cena);
        palco.show();
    }

    private void atualizarRelogio(Label labelHora, DateTimeFormatter formatador){
        labelHora.setText(LocalDateTime.now().format(formatador));
    }

    public static void main(String[] args) {
        launch(args);
    }
}