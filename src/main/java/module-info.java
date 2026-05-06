module com.example.gameproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.gameproject1 to javafx.fxml;
    exports com.example.gameproject1;
}