import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class Main {

    private static final String uri = "https://jsonplaceholder.typicode.com/comments?postId=1";
    private static final String line = "--------------------------------------------------------------------------------------------------------------------------";


    public static void main(String[] args) {


        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();


        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());


            ObjectMapper objectMapper = new ObjectMapper();

            List<Posts> posts = objectMapper.readValue(response.body(), new TypeReference<List<Posts>>() {
            });


            for (Posts post : posts) {
                System.out.printf("%s\n%s\n", post, line);
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
