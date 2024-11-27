package app;

import dataaccess.GusClient;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        GusClient client = new GusClient();
        System.out.println(client.readLoanData());
    }
}
