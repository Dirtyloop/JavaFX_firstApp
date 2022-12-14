module com.example.fx_hello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx_hello to javafx.fxml;
    exports com.example.fx_hello;
}