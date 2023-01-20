module com.example.day01code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.day01code to javafx.fxml;
    exports com.example.day01code;
}