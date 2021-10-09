import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Helper;
import requests.HttpGetRequest;
import requests.HttpPostRequest;
import requests.HttpPutRequest;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class Main {

    private static final String uriGet = "https://jsonplaceholder.typicode.com/comments?postId=1";
    private static final String uriPost = "https://jsonplaceholder.typicode.com/posts";
    private static final String uriPut = "https://jsonplaceholder.typicode.com/posts/1";


    public static void main(String[] args) {

        Helper.get(uriGet);

        Helper.post(uriGet,uriPost);

        Helper.put(uriGet,uriPut);


    }
}
