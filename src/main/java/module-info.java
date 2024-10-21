module org.hugo.ejerciciod {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.hugo.ejerciciod to javafx.fxml;
    exports org.hugo.ejerciciod;
}