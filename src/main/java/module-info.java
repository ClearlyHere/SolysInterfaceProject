module app.solys {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens app.solys to javafx.fxml;
    exports app.solys;
    exports app.solys.Controller;
    opens app.solys.Controller to javafx.fxml;
}