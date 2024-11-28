package app;

import dataaccess.GusClient;
import dto.DatabaseRowDto;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        GusClient client = new GusClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readLibraryData(2023));
        System.out.println(databaseRowDtoArrayList);
    }
}
