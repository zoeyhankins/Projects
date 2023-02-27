/*
 * PE 16-2 TrafficLight Part 2
 * Automate the stoplight from PE16-1  so that 
 * it changes color automatically after an appropriate 
 * amount of time. (i.e. cycles like a real stoplight)
 * 
 * Replace the color buttons with a "start" and "stop" 
 * button to control the light.
 * 
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TrafficLightPart2 extends Application {

    private Circle c1, c2, c3;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        // Create a vbox
        VBox paneForCircles = new VBox(5);
        paneForCircles.setAlignment(Pos.CENTER);

        // Create three circles
        c1 = getCircle();
        c2 = getCircle();
        c3 = getCircle();
        c1.setFill(Color.RED);

        // Place circles in vbox
        paneForCircles.getChildren().addAll(c1, c2, c3);

        // Create a rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.WHITE);
        rectangle.setWidth(30);
        rectangle.setHeight(100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        StackPane stopSign = new StackPane(rectangle, paneForCircles);

        // Create a hbox
        HBox paneForButtons = new HBox(5);
        paneForButtons.setAlignment(Pos.CENTER);

        // Create buttons
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");

        // Add buttons to hbox
        paneForButtons.getChildren().addAll(btnStart, btnStop);

        // Create a border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(stopSign);
        pane.setBottom(paneForButtons);

        // Create a timeline to change the traffic light colors
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e -> {
                    c1.setFill(Color.RED);
                    c2.setFill(Color.WHITE);
                    c3.setFill(Color.WHITE);
                }),
                new KeyFrame(Duration.seconds(5), e -> {
                    c1.setFill(Color.WHITE);
                    c2.setFill(Color.YELLOW);
                    c3.setFill(Color.WHITE);
                }),
                new KeyFrame(Duration.seconds(7), e -> {
                    c1.setFill(Color.WHITE);
                    c2.setFill(Color.WHITE);
                    c3.setFill(Color.GREEN);
                }),
                new KeyFrame(Duration.seconds(12), e -> {
                    c1.setFill(Color.RED);
                    c2.setFill(Color.WHITE);
                    c3.setFill(Color.WHITE);
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);

        // Add event handlers to the buttons
        btnStart.setOnAction(e -> {
            timeline.play();
        });

        btnStop.setOnAction(e -> {
            timeline.stop();
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 150);
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Return a circle */
    private Circle getCircle() {
        Circle c = new Circle(10);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        return c;
   
    }
}