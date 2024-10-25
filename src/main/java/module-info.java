module org.hugo.ejerciciod {
    requires javafx.controls;
    requires javafx.fxml;
    opens Model to javafx.base;
    exports org.hugo.ejerciciod;
    opens org.hugo.ejerciciod to javafx.fxml;
}
