package views.HittingTheTrail;

import Start.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import views.HittingTheTrail.TrailObjects.HorseForWagon;
import views.HittingTheTrail.TrailObjects.Wagon;

/**
 * Created by augustus on 3/7/16.
 * This is the scene the user will
 * see once the game gets going.
 * It strictly graphics but I need
 * to decide to either use gifs
 * or canvases
 */
public class TheTrail {
    //public static GridPane gridPane = new GridPane();
    public static Scene scene;
    public static GridPane gridPane;
    public static Canvas canvas1 = new Canvas(Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight()-30);
    public static GraphicsContext gc1 = canvas1.getGraphicsContext2D();
    public static Canvas canvas2 = new Canvas(Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight()-30);
    public static GraphicsContext gc2 = canvas2.getGraphicsContext2D();
    public static Timeline animateTimeline;

    public static void showTheTrailScene(){
        gridPane = new GridPane();
        gridPane.setId("TheTrailGridPaneMoving");
        gridPane.setAlignment(Pos.CENTER);

        Pane layeredCanvas = new Pane(canvas1, canvas2);

        animateTimeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            gc1.clearRect(Wagon.x, Wagon.y, Wagon.w+HorseForWagon.w+10+(HorseForWagon.x - Wagon.x), Wagon.h+HorseForWagon.h+10);
            gc1.strokeLine(Wagon.x+(Wagon.w/2), Wagon.y+162, HorseForWagon.x+HorseForWagon.w/2+25, HorseForWagon.y+HorseForWagon.h/2);
            gc1.drawImage(Wagon.img, Wagon.x, Wagon.y, Wagon.w, Wagon.h);
            gc1.drawImage(HorseForWagon.img, HorseForWagon.x, HorseForWagon.y, HorseForWagon.w, HorseForWagon.h);
            gc1.strokeLine(Wagon.x+(Wagon.w/2), Wagon.y+165, HorseForWagon.x+HorseForWagon.w/2+25, HorseForWagon.y+HorseForWagon.h/2);
        }));
        animateTimeline.setCycleCount(Animation.INDEFINITE);
        animateTimeline.play();

        gridPane.add(layeredCanvas, 0, 0);

        scene = new Scene(gridPane, Main.getPrimaryStage().getScene().getWidth(), Main.getPrimaryStage().getScene().getHeight());
        scene.getStylesheets().addAll("resources/main.css");

        Main.getPrimaryStage().setScene(scene);
    }

}
