module com.itheima.array {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itheima.array1 to javafx.fxml;
    exports com.itheima.array1;
}