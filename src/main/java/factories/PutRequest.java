package factories;

import interfaces.Request;
import interfaces.RequestFactory;
import requests.HttpPutRequest;


public class PutRequest<T> implements RequestFactory {
    @Override
    public Request createRequest() {
        return new HttpPutRequest<T>();
    }
}
