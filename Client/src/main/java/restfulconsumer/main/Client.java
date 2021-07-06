package restfulconsumer.main;

import restfulconsumer.consumer.Consumer;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Consumer c = new Consumer();
        c.getHello();
        c.getStructure();
    }
}
