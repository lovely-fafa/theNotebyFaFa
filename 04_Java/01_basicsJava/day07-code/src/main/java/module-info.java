module com.itheima.oop.day07code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itheima.oop to javafx.fxml;
    exports com.itheima.oop;
}