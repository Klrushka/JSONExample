package requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.Request;
import models.Posts;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.function.Supplier;

public class HttpPostRequest<T> implements Request {

    private static final String line = "--------------------------------------------------------------------------------------------------------------------------";

    final static Logger LOGGER = Logger.getLogger(HttpGetRequest.class);

    public void doRequest(String... uri) {


        System.out.println("POST REQUEST");

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpGetRequest<T> request = new HttpGetRequest<>();

        List<T>  posts =  request.getModels(uri[0]);



        try {




            for (T post : posts) {

                ObjectMapper objectMapper = new ObjectMapper();

                String s = objectMapper.writeValueAsString(post);

                LOGGER.info("Post objects turn into string");

                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(s))
                        .header("accept", "application/json")
                        .uri(URI.create(uri[1]))
                        .build();

                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                LOGGER.info("Response send");

                System.out.println(response);
                System.out.println(response.body());
            }

            LOGGER.info("Posts post request info displayed");
;

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("IOException");
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.error("InterruptedException");
        }
    }
}
