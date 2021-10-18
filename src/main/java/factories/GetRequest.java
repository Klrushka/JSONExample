package factories;

import interfaces.Request;
import interfaces.RequestFactory;
import requests.HttpGetRequest;


public class GetRequest<T> implements RequestFactory {

    @Override
    public Request createRequest() {
        return new HttpGetRequest<T>();
    }
}
