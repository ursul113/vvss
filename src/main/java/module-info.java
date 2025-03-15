module inventory {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires org.apache.logging.log4j;

    opens inventory.model to javafx.base;
    exports inventory.model;
    opens inventory to javafx.fxml;
    exports inventory;
    opens inventory.controller to javafx.fxml;
    exports inventory.controller;
}