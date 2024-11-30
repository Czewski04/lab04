package dataaccess;

import dto.DatabaseRowDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static clientservice.ClientService.dataDeserialization;

public class MainDataClient {

    private final HttpClient client;

    public MainDataClient() {
        client = HttpClient.newHttpClient();
    }

    public ArrayList<DatabaseRowDto> readLoanData(int year) throws IOException, InterruptedException {
        String loanOfTheBookCollectionUrl = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=129&id-przekroj=591&id-okres=282&id-rok=" + year;
        return readData(loanOfTheBookCollectionUrl);
    }

    public ArrayList<DatabaseRowDto> readReadersData(int year) throws IOException, InterruptedException {
        String readersUrl = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=493&id-przekroj=591&id-okres=282&id-rok=" + year;
        return readData(readersUrl);
    }

    public ArrayList<DatabaseRowDto> readPlacesForReadersData(int year) throws IOException, InterruptedException {
        String placesForReadersUrl = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=494&id-przekroj=591&id-okres=282&id-rok=" + year;
        return readData(placesForReadersUrl);
    }

    public ArrayList<DatabaseRowDto> readLibraryData(int year) throws IOException, InterruptedException {
        String libraryUrl = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=747&id-przekroj=541&id-okres=282&ile-na-stronie=5000&id-rok=" + year;
        return readData(libraryUrl);
    }

    private ArrayList<DatabaseRowDto> readData(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return dataDeserialization(response.body());
    }
}
