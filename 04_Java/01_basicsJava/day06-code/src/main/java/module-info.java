module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itheima.test to javafx.fxml;
    exports com.itheima.test;
}