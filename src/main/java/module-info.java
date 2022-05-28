module at.ac.fhcampuswien {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;

    exports at.ac.fhcampuswien;
    opens at.ac.fhcampuswien to javafx.fxml;
    exports GUI;
    opens GUI to javafx.fxml;

}