module lab04.client {
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens dto to com.fasterxml.jackson.databind;
    exports dto;
}