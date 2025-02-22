module org.example.classtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens org.example.classtest to javafx.fxml;
    exports org.example.classtest;
    opens org.example.classtest.models to javafx.base;
}