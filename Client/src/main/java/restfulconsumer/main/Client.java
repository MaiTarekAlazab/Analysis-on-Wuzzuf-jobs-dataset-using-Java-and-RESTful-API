package restfulconsumer.main;

import restfulconsumer.consumer.Consumer;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Consumer c = new Consumer();
        System.out.println("this is the output of get hello");
        c.getHello();
        System.out.println("this is the output of get Data");
        c.getData();
        System.out.println("this is the output of get Structure");
        c.getStructure();
        System.out.println("this is the output of get Summary");
        c.getSummary();
        System.out.println("this is the output of get Clean");
        //c.getClean();
        System.out.println("this is the output of get Job");
        c.getJob();
        System.out.println("this is the output of get Titles");
        c.getMostTitles();
        System.out.println("this is the output of get Areas");
        c.getMostAreas();
        //c.getImg();
    }
}
