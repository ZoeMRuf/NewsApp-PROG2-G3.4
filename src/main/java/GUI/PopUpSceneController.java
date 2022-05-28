package GUI;

import API_Enums.Category;
import API_Enums.Country;
import API_Enums.Language;
import API_Enums.Sortby;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopUpSceneController implements Initializable {
    @FXML
    private ChoiceBox<Country> countryChoiceBox = new ChoiceBox<>();
    private Country[] count = Country.values();
    @FXML
    private ChoiceBox<Language> languageChoiceBox = new ChoiceBox<>();
    private Language[] lang = Language.values();
    @FXML
    private ChoiceBox<Sortby> sortByChoiceBox = new ChoiceBox<>();
    private Sortby[] sort = Sortby.values();
    @FXML
    private ChoiceBox<Category> categoryChoiceBox = new ChoiceBox<>();
    private Category[] cate = Category.values();
    @FXML
    private TextField topHeadlineQueryTextField;
    @FXML
    private TextField everythingQueryTextField;

    private Country currentCountry = Country.AUSTRIA;
    private Language currentLanguage = Language.GERMAN;
    private Sortby currentSortBy = Sortby.POPULARITY;
    private Category currentCategory = Category.GENERAL;
    private String topHeadlineQuery = "corona";
    private String everythingQuery = "bitcoin";


    public static void display(String title, ActionEvent actionEvent) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(PopUpSceneController.class.getResource("/PopUpScene.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(title);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countryChoiceBox.getItems().addAll(count);
        countryChoiceBox.setValue(currentCountry);

        languageChoiceBox.getItems().addAll(lang);
        languageChoiceBox.setValue(currentLanguage);

        sortByChoiceBox.getItems().addAll(sort);
        sortByChoiceBox.setValue(currentSortBy);

        categoryChoiceBox.getItems().addAll(cate);
        categoryChoiceBox.setValue(currentCategory);
    }

    public void confirm(ActionEvent actionEvent) throws IOException {
        currentCountry = countryChoiceBox.getValue();
        currentLanguage = languageChoiceBox.getValue();
        currentSortBy = sortByChoiceBox.getValue();
        currentCategory = categoryChoiceBox.getValue();

        if(!topHeadlineQueryTextField.getText().equals("")){
            topHeadlineQuery = topHeadlineQueryTextField.getText();
        }
        if(!everythingQueryTextField.getText().equals("")){
            everythingQuery = everythingQueryTextField.getText();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ArticleScene.fxml"));
        Parent root = loader.load();
        ArticleSceneController articleSceneController = loader.getController();
        articleSceneController.currentState(currentCountry, currentLanguage, currentSortBy, currentCategory, topHeadlineQuery, everythingQuery);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
