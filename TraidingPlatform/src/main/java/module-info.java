module org.devteam.platformfx{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens org.devteam to javafx.fxml;
    exports org.devteam;
}