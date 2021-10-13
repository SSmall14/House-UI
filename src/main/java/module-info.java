module com.example.MainApplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;

//    requires charm;
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.display;

    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires org.json;

    opens com.example to javafx.fxml;
    exports com.example;
}