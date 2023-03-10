/*
 * PE 16-3 CountDownTimer
 * Write a program that allows the user to enter time in 
 * seconds in the text field and press the Enter key to count 
 * down the seconds. 
 * The remaining seconds are redisplayed every second. 
 * When the seconds are expired, the program starts to play 
 * music continuously.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

public class CountDownTimer extends Application {
    protected TextField count = new TextField();
    protected Media media = new Media(
            "C:/Users/Zoey/Downloads/audio.mp3");
    protected MediaPlayer mediaPlayer = new MediaPlayer(media);

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        count.setAlignment(Pos.CENTER);
        count.setFont(Font.font(60));
        count.setPrefColumnCount(4);

        // Create a pane
        StackPane pane = new StackPane(count);

        // Create animation for stopwatch
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> run()));
        animation.setCycleCount(Timeline.INDEFINITE);

        count.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.ENTER) {
                        animation.play();
                    }
            });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("CountDownTimer"); // Set the Stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void run() {
        if (Integer.parseInt(count.getText()) > 0) {
            count.setText(String.valueOf(
                    Integer.parseInt(count.getText()) - 1));
        }
        if (count.getText().equals("0")) {
            mediaPlayer.play();
        }
    }
}