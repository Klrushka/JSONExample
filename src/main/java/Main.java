
import helpers.Helper;

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
