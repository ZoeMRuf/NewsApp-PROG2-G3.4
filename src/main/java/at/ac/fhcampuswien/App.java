package at.ac.fhcampuswien;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App{
    public static void main(String[] args) {

        Menu menu = new Menu(); //Instance of Menu to work with
        menu.start();

        //launch(args);
    }
/*
    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 700,500);
        scene.setFill(Color.rgb(233,233,230));

        Image newsIcon = new Image(getClass().getResource("/NewsIcon.png").toExternalForm());
        stage.getIcons().add(newsIcon);

        Text menuText = new Text("\n  *   Welcome to NewsApp   *  \n");
        menuText.setFont(Font.font ("Verdana", 50));
        menuText.setFill(Color.BLACK);
        root.getChildren().add(menuText);

        stage.setTitle("News-App");
        stage.setScene(scene);
        stage.show();

    }
*/
}
