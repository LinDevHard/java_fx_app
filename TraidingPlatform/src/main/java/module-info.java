module org.devteam.platformfx{
    requires javafx.controls;
    requires javafx.fxml;

    opens org.devteam to javafx.fxml;
    exports org.devteam;
}