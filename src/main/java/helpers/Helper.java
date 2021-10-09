package helpers;

import requests.HttpGetRequest;
import requests.HttpPostRequest;
import requests.HttpPutRequest;

public class Helper {


    public static void get(String uriGet){
        HttpGetRequest.get(uriGet);
    }


    public static void post(String uriGet, String uriPost){
        HttpPostRequest.post(uriGet, uriGet);
    }


    public static void put(String uriGet, String uriPost){
        HttpPutRequest.put(uriGet,uriPost);
    }

}
