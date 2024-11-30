package app;

import dataaccess.MainDataClient;
import dto.DatabaseRowDto;
import model.DatabaseRow;
import clientservice.ClientService;

import java.io.IOException;
import java.util.ArrayList;

public class ApiClientApp extends ClientService {

    public ArrayList<DatabaseRow> getDatabaseRowsListLibraryData(int year) throws IOException, InterruptedException {
        MainDataClient client = new MainDataClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readLibraryData(year));
        return new ArrayList<>(convertToModel(databaseRowDtoArrayList));
    }

    public ArrayList<DatabaseRow> getDatabaseRowsListBookLoanData(int year) throws IOException, InterruptedException {
        MainDataClient client = new MainDataClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readLoanData(year));
        return new ArrayList<>(convertToModel(databaseRowDtoArrayList));
    }

    public ArrayList<DatabaseRow> getDatabaseRowsListReadersData(int year) throws IOException, InterruptedException {
        MainDataClient client = new MainDataClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readReadersData(year));
        return new ArrayList<>(convertToModel(databaseRowDtoArrayList));
    }

    public ArrayList<DatabaseRow> getDatabaseRowsListPlacesForReadersData(int year) throws IOException, InterruptedException {
        MainDataClient client = new MainDataClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readPlacesForReadersData(year));
        return new ArrayList<>(convertToModel(databaseRowDtoArrayList));
    }
}
