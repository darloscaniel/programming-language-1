module org.example.classtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.classtest to javafx.fxml;
    exports org.example.classtest;
    opens org.example.classtest.models to javafx.fxml;
}