module com.example.day02code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.day02code to javafx.fxml;
    exports com.example.day02code;
}