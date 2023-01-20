module com.example.day08code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itheima.string to javafx.fxml;
    exports com.itheima.string;
}