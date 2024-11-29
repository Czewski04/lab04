package app;

import dataaccess.MainDataClient;
import dto.DatabaseRowDto;
import model.DatabaseRow;
import service.DtoToModel;

import java.io.IOException;
import java.util.ArrayList;

public class Application extends DtoToModel {

    public static ArrayList<DatabaseRow> getDatabaseRowsListLibraryData(int year) throws IOException, InterruptedException {
        MainDataClient client = new MainDataClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readLibraryData(year));
        ArrayList<DatabaseRow> databaseRowsList = new ArrayList<>(convertToModel(databaseRowDtoArrayList));
        return databaseRowsList;
    }
}
