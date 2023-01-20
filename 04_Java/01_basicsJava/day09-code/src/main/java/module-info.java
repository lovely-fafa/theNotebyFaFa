module com.itheima.list.day09code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itheima.list to javafx.fxml;
    exports com.itheima.list;
}