package requests;

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

public class HttpPutRequest<T> implements Request {

    final static Logger LOGGER = Logger.getLogger(HttpGetRequest.class);

    public void doRequest(String... uri) {


        System.out.println("PUT REQUEST");

        HttpClient httpClient = HttpClient.newHttpClient();


        HttpGetRequest<T> request = new HttpGetRequest<>();

        T  posts =  request.getModels(uri[0]);



        try {




                ObjectMapper objectMapper = new ObjectMapper();

                String s = objectMapper.writeValueAsString(posts);

                LOGGER.info("Post objects turn into string");

                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .PUT(HttpRequest.BodyPublishers.ofString(s))
                        .header("accept", "application/json")
                        .uri(URI.create(uri[2]))
                        .build();

                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                LOGGER.info("Response send");

                System.out.println(response);
                System.out.println(response.body());


            LOGGER.info("Posts put request info displayed");

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("IOException");
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.error("InterruptedException");
        }
    }
}
