import factories.FactoryGetter;
import factories.GetRequest;
import interfaces.Request;
import interfaces.RequestFactory;
import models.Posts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // String... uri

    private static final String uriGet = "https://jsonplaceholder.typicode.com/comments?postId=1";      // uri[0]
    private static final String uriPost = "https://jsonplaceholder.typicode.com/posts";                 // uri[1]
    private static final String uriPut = "https://jsonplaceholder.typicode.com/posts/1";                // uri[2]


    public static void main(String[] args) {


        System.out.println("What is request you need?(get/post/put)");

        FactoryGetter<ArrayList<Posts>> factoryGetter = new FactoryGetter<>();

        RequestFactory requestFactory = factoryGetter.getFactory(new Scanner(System.in).nextLine());

        if (requestFactory != null){

            Request request = requestFactory.createRequest();

            request.doRequest(uriGet,uriPost,uriPut);


        } else {
            throw new RuntimeException();
        }


    }



}
