module com.itheima.operator.day03code {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itheima.operator.day03code to javafx.fxml;
    exports com.itheima.operator.day03code;
}