package factories;

import interfaces.RequestFactory;

public class FactoryGetter<T> {
    public RequestFactory getFactory(String factory) {

        if (factory.equalsIgnoreCase("get")) {

            return new GetRequest<T>();

        } else if (factory.equalsIgnoreCase("post")) {

            return new PostRequest<T>();

        } else if (factory.equalsIgnoreCase("put")) {

            return new PutRequest<T>();

        } else {

            System.out.println("Factory error");
            return null;

        }

    }
}
