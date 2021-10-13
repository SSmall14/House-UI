module com.example.MainApplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;

//    requires charm;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.display;

//    requires httpclient;
    requires org.apache.httpcomponents.httpcore;

    opens com.example to javafx.fxml;
    exports com.example;
}