package dataaccess;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GusClient {

    private final HttpClient client;

    public GusClient() {
        client = HttpClient.newHttpClient();
    }

    public String readLoanData() throws IOException, InterruptedException {
        String loanOfTheBookCollection = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=129&id-przekroj=591&id-rok=2023&id-okres=282";
        return readData(loanOfTheBookCollection);
    }

    public String readReadersData() throws IOException, InterruptedException {
        String readers = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=493&id-przekroj=591&id-rok=2023&id-okres=282";
        return readData(readers);
    }

    public String placesForReadersData() throws IOException, InterruptedException {
        String placesForReaders = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=494&id-przekroj=591&id-rok=2023&id-okres=282";
        return readData(placesForReaders);
    }

    public String readLibraryData() throws IOException, InterruptedException {
        String library = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-data-section?id-zmienna=747&id-przekroj=541&id-rok=2023&id-okres=282&ile-na-stronie=5000";
        return readData(library);
    }

    private String readData(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
