package GUI;

import API_Enums.*;
import GUI.PopUpSceneController;
import at.ac.fhcampuswien.AppController;
import at.ac.fhcampuswien.NewAPIException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ArticleSceneController{
    @FXML
    private Button back_button;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private ScrollPane extraInfoScroll;
    @FXML
    private Button topHeadlines_button;
    @FXML
    private Button everything_button;

    private Country currentCountry = Country.AUSTRIA;
    private Language currentLanguage = Language.GERMAN;
    private Sortby currentSortBy = Sortby.POPULARITY;
    private Category currentCategory = Category.GENERAL;
    private String topHeadlineQuery = "corona";
    private String everythingQuery = "bitcoin";

    private final AppController ctl = new AppController();

    public void changeStartMenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/StartMenu.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeBackButtonRed(MouseEvent mouseEvent) {
        back_button.setGraphic(new ImageView("/Back_Red.png"));
    }

    public void changeBackButtonBlack(MouseEvent mouseEvent) {
        back_button.setGraphic(new ImageView("/Back_Black.png"));
    }

    public void topHeadlineArticles(ActionEvent actionEvent) {
        String articleString = ctl.getConfiguredArticles(Endpoint.TOPHEADLINE, currentCountry, currentLanguage, currentCategory, currentSortBy, topHeadlineQuery)
                .toString().replaceAll("\\[", "").replaceAll("\\]", "");
        Label label = new Label(articleString);

        scroll_pane.setContent(label);

        StringBuilder strBld = new StringBuilder();
        Label extra = new Label();
        extra.setFont(new Font("Arial", 15));

        strBld.append("\nProvider with the most articles:\n");
        strBld.append(ctl.getMostPopularSources()).append("\n");
        strBld.append("\nAuthor with the longest name:\n").append(ctl.getLongestAuthorName()).append("\n");
        strBld.append("\n\"New York Times\" Atricles: ").append(ctl.getNewYorkTimesArticleCount()).append("\n");
        strBld.append("\nNumber of Articles: ").append(ctl.getArticleCount()).append("\n");

        if(ctl.getShortHeadlines().size() != 0){
            strBld.append("Short titles:\n");
            strBld.append(ctl.getShortHeadlines()
                    .toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        }

        extra.setText(strBld.toString());
        extraInfoScroll.setContent(extra);
    }

    public void searchedArticles(ActionEvent actionEvent) {
        String articleString = ctl.getConfiguredArticles(Endpoint.EVERYTHING, currentCountry, currentLanguage, currentCategory, currentSortBy, everythingQuery)
                .toString().replaceAll("\\[", "").replaceAll("\\]", "");
        Label label = new Label(articleString);

        scroll_pane.setContent(label);

        StringBuilder strBld = new StringBuilder();
        Label extra = new Label();
        extra.setFont(new Font("Arial", 15));

        strBld.append("\nProvider with the most articles:\n");
        strBld.append(ctl.getMostPopularSources()).append("\n");
        strBld.append("\nAuthor with the longest name:\n").append(ctl.getLongestAuthorName()).append("\n");
        strBld.append("\n\"New York Times\" Atricles: ").append(ctl.getNewYorkTimesArticleCount()).append("\n");
        strBld.append("\nNumber of Articles: ").append(ctl.getArticleCount()).append("\n");

        if(ctl.getShortHeadlines().size() != 0){
            strBld.append("Short titles:\n");
            strBld.append(ctl.getShortHeadlines()
                    .toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        }

        extra.setText(strBld.toString());
        extraInfoScroll.setContent(extra);
    }

    public void sortByD(ActionEvent actionevent) {
        String articleString = ctl.sortedByDescription()
                .toString().replaceAll("\\[", "").replaceAll("\\]", "");
        Label label = new Label(articleString);
        scroll_pane.setContent(label);
    }

    public void popUpScene(ActionEvent actionEvent) throws IOException {
        PopUpSceneController.display("Configuration", actionEvent);
    }

    public void currentState(Country cont, Language lang, Sortby sort, Category cat, String topHeadlineQuery, String everythingQuery){
        currentCountry = cont;
        currentLanguage = lang;
        currentSortBy = sort;
        currentCategory = cat;
        this.topHeadlineQuery = topHeadlineQuery;
        this.everythingQuery = everythingQuery;

        topHeadlines_button.setText("Get top headlines " + currentCountry);
        everything_button.setText("Get all news about " + everythingQuery);
    }
}
