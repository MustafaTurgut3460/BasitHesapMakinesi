module com.example.hesapmakinesi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hesapmakinesi to javafx.fxml;
    exports com.example.hesapmakinesi;
}