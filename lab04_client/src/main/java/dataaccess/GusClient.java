package dataaccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DatabaseRowDto;
import dto.ResponseDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class GusClient {

    private final HttpClient client;

    public GusClient() {
        client = HttpClient.newHttpClient();
    }

    public ArrayList<DatabaseRowDto> readLoanData(int year) throws IOException, InterruptedException {
        String loanOfTheBookCollection = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=129&id-przekroj=591&id-okres=282&id-rok=" + year;
        return readData(loanOfTheBookCollection);
    }

    public ArrayList<DatabaseRowDto> readReadersData(int year) throws IOException, InterruptedException {
        String readers = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=493&id-przekroj=591&id-okres=282&id-rok=" + year;
        return readData(readers);
    }

    public ArrayList<DatabaseRowDto> readPlacesForReadersData(int year) throws IOException, InterruptedException {
        String placesForReaders = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=494&id-przekroj=591&id-okres=282&id-rok=" + year;
        return readData(placesForReaders);
    }

    public ArrayList<DatabaseRowDto> readLibraryData(int year) throws IOException, InterruptedException {
        String library = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=747&id-przekroj=541&id-okres=282&ile-na-stronie=5000&id-rok=" + year;
        return readData(library);
    }

    private ArrayList<DatabaseRowDto> readData(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return deserialization(response.body());
    }

    private ArrayList<DatabaseRowDto> deserialization(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseDto responseDto = mapper.readValue(response, ResponseDto.class);
        return responseDto.getData();
    }
}
