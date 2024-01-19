module com.example.taskcore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taskcore to javafx.fxml;
    exports com.example.taskcore;
}