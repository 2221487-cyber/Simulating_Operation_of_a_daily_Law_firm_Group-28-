module com.project.sec3_2221869_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens com.project.sec3_2221869_project to javafx.fxml;
    exports com.project.sec3_2221869_project;
}