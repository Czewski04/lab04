module lab04.client {
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens dto to com.fasterxml.jackson.databind;
    opens app to lab04.gui;
    exports dto;
    exports app;
    exports dataaccess;
    exports model;
    exports clientservice;
}