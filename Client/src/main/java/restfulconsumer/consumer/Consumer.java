package restfulconsumer.consumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import restfulconsumer.utils.Image;
import restfulconsumer.utils.TableDecoder;
import restfulconsumer.utils.UtilBase64Image;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Consumer {
    private RestTemplate restTemplate;

    public Consumer() {
        restTemplate = new RestTemplate();
    }

    public void getHello() {
        final String uri = "http://localhost:8080/data/test";
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    public void getData() throws IOException {
        final String uri = "http://localhost:8080/data/disdata";
        Map<String,List<String>> response = restTemplate.getForObject(uri, Map.class);

        //decode
        TableDecoder Tdecoder = new TableDecoder();
        Table t = Tdecoder.decode(response);
        System.out.println(t.printAll());
    }

    public void getStructure() throws IOException {
        final String uri = "http://localhost:8080/data/structure";
        Map<String, List<String>>  response = restTemplate.getForObject(uri, Map.class);

        //decode
        TableDecoder Tdecoder = new TableDecoder();
        Table t = Tdecoder.decode(response);
        System.out.println(t.printAll());
    }

    public void getSummary() throws IOException {
        final String uri = "http://localhost:8080/data/summary";
        Map<String, List<String>> response = restTemplate.getForObject(uri, Map.class);

        //decode
        TableDecoder Tdecoder = new TableDecoder();
        Table t = Tdecoder.decode(response);
        System.out.println(t.printAll());
    }

    public void getClean() throws IOException {
        final String uri = "http://localhost:8080/data/clean";
        Map<String,String> response = restTemplate.getForObject(uri, Map.class);
        System.out.println("Most important required skills: ");
        for (Map.Entry<String, String> entry: response.entrySet()) {
            System.out.println(entry.getKey() + " table shape is: " + entry.getValue());
        }
    }

    public void getJob() throws IOException {
        final String uri = "http://localhost:8080/data/job";
        Map<String, Long> response = restTemplate.getForObject(uri, Map.class);
        System.out.println("The number of jobs in each company are: ");
        System.out.println(response);
    }
    public void getMostTitles() throws IOException {
        final String uri = "http://localhost:8080/data/titles";
        Map <String, Long> response = restTemplate.getForObject(uri, Map.class);
        System.out.println("The number of each title in the data et: ");
        System.out.println(response);
    }
    public void getMostAreas() throws IOException {
        final String uri = "http://localhost:8080/data/areas";
        Map<String,Long> response = restTemplate.getForObject(uri, Map.class);
        System.out.println("The number of occurrence of each area in the dataset: ");
        System.out.println(response);
    }
    public void getSkills() throws IOException {
        final String uri = "http://localhost:8080/data/skills";
        Map response = restTemplate.getForObject(uri, Map.class);
        System.out.println("The number of occurrence of each skill in the dataset: ");
        System.out.println(response);
    }
    public void getCleanedDataAfterFactorizing() throws IOException {
        final String uri = "http://localhost:8080/data/factorize";
        Map<String,List<String>> response = restTemplate.getForObject(uri, Map.class);
        TableDecoder Tdecoder = new TableDecoder();
        Table t = Tdecoder.decode(response);
        System.out.println(t.printAll());
    }

    public void getpiechart() throws IOException {
        String getUrl = "http://localhost:8080/data/pie";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity getResponse = restTemplate.getForEntity(getUrl, Image.class);

        if(getResponse.getBody() != null){
            Image image1 = (Image) getResponse.getBody();
            UtilBase64Image.decoder(image1.getData(), "src/main/resources/images/" + image1.getName() +".jpg");
            System.out.println("Done!");
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }
    public void getbarchart1() throws IOException {
        String getUrl = "http://localhost:8080/data/bar1";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity getResponse = restTemplate.getForEntity(getUrl, Image.class);

        if(getResponse.getBody() != null){
            Image image2 = (Image) getResponse.getBody();
            UtilBase64Image.decoder(image2.getData(), "src/main/resources/images/" + image2.getName() +".jpg");
            System.out.println("Done!");
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }
   public void getbarchart2() throws IOException {
        String getUrl = "http://localhost:8080/data/bar2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity getResponse = restTemplate.getForEntity(getUrl, Image.class);

        if(getResponse.getBody() != null){
            Image image3 = (Image) getResponse.getBody();
            UtilBase64Image.decoder(image3.getData(), "src/main/resources/images/" + image3.getName() +".jpg");
            System.out.println("Done!");
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }



    /*public static void getTestConsume() throws IOException {
        final String uri = "http://localhost:8080/consume";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        List<String> t = JSONUtils.covertFromJsonToObject(result, List.class);
        System.out.println(t);
    }*/





}
