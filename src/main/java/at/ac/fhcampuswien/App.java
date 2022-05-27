package at.ac.fhcampuswien;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App extends Application {
    public static void main(String[] args){

        /*
        try{
            Menu menu = new Menu(); //Instance of Menu to work with
            menu.start();
        }
        catch (NewAPIException e){
            System.out.println(e.getMessage());
        }

         */
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/StartMenu.fxml"));
        Scene scene = new Scene(root,1000,700);

        Image newsIcon = new Image(getClass().getResource("/NewsIcon.png").toExternalForm());
        stage.getIcons().add(newsIcon);
        stage.setTitle("News-App");
        stage.setScene(scene);
        stage.show();

    }
}
