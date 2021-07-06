package restfulconsumer.main;

import restfulconsumer.consumer.Consumer;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Consumer c = new Consumer();
        System.out.println("\nthis is the output of get hello");
        c.getHello();
        System.out.println("\nthis is the output of get Data");
        c.getData();
        System.out.println("\nthis is the output of get Structure");
        c.getStructure();
        System.out.println("\nthis is the output of get Summary");
        c.getSummary();
        System.out.println("\nthis is the output of get Clean");
        c.getClean();
        System.out.println("\nthis is the output of get Job");
        c.getJob();
        System.out.println("\nthis is the output of get Titles");
        c.getMostTitles();
        System.out.println("\nthis is the output of get Areas");
        c.getMostAreas();
        System.out.println("\nthis is the output of get skills");
        c.getSkills();
        System.out.println("\nthis is the output of factorize");
        c.getCleanedDataAfterFactorizing();
        System.out.println("this is the output of get pie");
        c.getpiechart();
        System.out.println("this is the output of get bar1");
        c.getbarchart1();
        System.out.println("this is the output of get bar2");
        c.getbarchart2();

    }
}
