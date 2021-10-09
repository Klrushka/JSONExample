package requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Posts;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class HttpGetRequest {

    private static final String line = "--------------------------------------------------------------------------------------------------------------------------";

    final static Logger LOGGER = Logger.getLogger(HttpGetRequest.class);

    public static void get(String uri) {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();

        LOGGER.info("Object HttpRequest created");


        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            LOGGER.info("Request sent");

            System.out.println(response.body());


            ObjectMapper objectMapper = new ObjectMapper();

            List<Posts> posts = objectMapper.readValue(response.body(), new TypeReference<>() {
            });


            LOGGER.info("Post objects mapped");

            for (Posts post : posts) {
                System.out.printf("%s\n%s\n", post, line);
            }

            LOGGER.info("Posts displayed");


        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("IOException");
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.error("InterruptedException");
        }
    }


    public static List<Posts> getModels (String uri){
        List<Posts> posts = Collections.emptyList();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();

        LOGGER.info("Object HttpRequest created");


        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            LOGGER.info("Request sent");


            ObjectMapper objectMapper = new ObjectMapper();

            posts = objectMapper.readValue(response.body(), new TypeReference<>() {
            });


            LOGGER.info("Post objects mapped");


        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("IOException");
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.error("InterruptedException");
        }

        return posts;
    }






}
