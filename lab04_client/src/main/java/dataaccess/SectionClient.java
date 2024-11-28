package dataaccess;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.SectionDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SectionClient {
    private final HttpClient client;

    public SectionClient() {
        client = HttpClient.newHttpClient();
    }

    public ArrayList<SectionDto> readSectionsTitles(int section) throws IOException, InterruptedException {
        String sectionsUrl = "https://api-dbw.stat.gov.pl/api/1.1.0/variable/variable-section-position?id-przekroj="+section;
        return readData(sectionsUrl);
    }

    private ArrayList<SectionDto> readData(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return deserialization(response.body());
    }

    private ArrayList<SectionDto> deserialization(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, new TypeReference<>() {});
    }
}
