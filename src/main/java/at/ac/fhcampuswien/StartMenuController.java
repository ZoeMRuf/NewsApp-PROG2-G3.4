package at.ac.fhcampuswien;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenuController {
    @FXML
    private ImageView start;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void changeArticleScene(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/ArticleScene.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeStartButtonRed(MouseEvent mouseEvent) {
        start.setImage(new Image("/Start_Red.png"));
    }

    public void changeStartButtonBlack(MouseEvent mouseEvent) {
        start.setImage(new Image("/Start_Black.png"));
    }


}
