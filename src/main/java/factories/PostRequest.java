package factories;

import interfaces.Request;
import interfaces.RequestFactory;
import requests.HttpPostRequest;


public class PostRequest<T> implements RequestFactory {
    @Override
    public Request createRequest() {
        return new HttpPostRequest<T>();
    }
}
