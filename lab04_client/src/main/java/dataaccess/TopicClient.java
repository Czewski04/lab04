package dataaccess;

import dto.TopicDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static clientservice.ClientService.topicDeserialization;

public class TopicClient {
    private final HttpClient client;

    public TopicClient() {
        client = HttpClient.newHttpClient();
    }

    public ArrayList<TopicDto> readTopic() throws IOException, InterruptedException {
        String topicUrl = "https://api-dbw.stat.gov.pl/api/1.1.0/area/area-variable?id-obszaru=72";
        return readData(topicUrl);
    }

    private ArrayList<TopicDto> readData(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return topicDeserialization(response.body());
    }
}
