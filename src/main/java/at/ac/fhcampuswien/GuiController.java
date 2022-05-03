package at.ac.fhcampuswien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button start_button;
    @FXML
    private Button back_button;

    public void changeArticleScene(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ArticleScene.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeStartButtonRed(MouseEvent mouseEvent) {
        start_button.setGraphic(new ImageView("/Start_Red.png"));
    }

    public void changeStartButtonBlack(MouseEvent mouseEvent) {
        start_button.setGraphic(new ImageView("/Start_Black.png"));
    }


    public void changeStartMenu(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/StartMenu.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeBackButtonRed(MouseEvent mouseEvent) {
        back_button.setGraphic(new ImageView("/Back_Red.png"));
    }

    public void changeBackButtonBlack(MouseEvent mouseEvent) {
        back_button.setGraphic(new ImageView("/Back_Black.png"));
    }
}
