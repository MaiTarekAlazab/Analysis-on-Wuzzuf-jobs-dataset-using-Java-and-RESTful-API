package restfulconsumer.consumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import restfulconsumer.utils.Image;
import restfulconsumer.utils.JSONDecoder;
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
        String response = restTemplate.getForObject(uri, String.class);

        //decode
        TableDecoder Tdecoder = new TableDecoder();
        JSONDecoder Jdecoder = new JSONDecoder();
        Map<String, List<String>> map = Jdecoder.covertFromJsonToObject(response, Map.class);
        System.out.println(map);
        //Table t = Tdecoder.decode(map);
        //System.out.println(t.printAll());
    }

    public void getStructure() throws IOException {
        final String uri = "http://localhost:8080/data/structure";
        String response = restTemplate.getForObject(uri, String.class);

        //decode
        TableDecoder Tdecoder = new TableDecoder();
        JSONDecoder Jdecoder = new JSONDecoder();
        Map<String, List<String>> map = Jdecoder.covertFromJsonToObject(response, Map.class);
        System.out.println(map);
        //Table t = Tdecoder.decode(map);
        //System.out.println(t.printAll());
    }

    public void getSummary() throws IOException {
        final String uri = "http://localhost:8080/data/summary";
        String response = restTemplate.getForObject(uri, String.class);

        //decode
        TableDecoder Tdecoder = new TableDecoder();
        JSONDecoder Jdecoder = new JSONDecoder();
        Map<String, List<String>> map = Jdecoder.covertFromJsonToObject(response, Map.class);
        System.out.println(map);
        //Table t = Tdecoder.decode(map);
        //System.out.println(t.printAll());
    }

    //unfinished
    /*public void getClean() throws IOException {
        final String uri = "http://localhost:8080/data/clean";
        String response = restTemplate.getForObject(uri, String.class);


        //decode
        TableDecoder Tdecoder = new TableDecoder();
        JSONDecoder Jdecoder = new JSONDecoder();
        Map<String, List<String>> map = Jdecoder.covertFromJsonToObject(response, Map.class);
        System.out.println(map);
        //Table t = Tdecoder.decode(map);
        //System.out.println(t.printAll());
    }*/

    public void getJob() throws IOException {
        final String uri = "http://localhost:8080/data/job";
        Map response = restTemplate.getForObject(uri, Map.class);
        System.out.println(response);
    }
    public void getMostTitles() throws IOException {
        final String uri = "http://localhost:8080/data/titles";
        Map response = restTemplate.getForObject(uri, Map.class);
        System.out.println(response);
    }
    public void getMostAreas() throws IOException {
        final String uri = "http://localhost:8080/data/titles";
        Map response = restTemplate.getForObject(uri, Map.class);
        System.out.println(response);
    }




    /*public static void getTestConsume() throws IOException {
        final String uri = "http://localhost:8080/consume";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        List<String> t = JSONUtils.covertFromJsonToObject(result, List.class);
        System.out.println(t);
    }*/

    /*public static void getImg() {
        String getUrl = "http://localhost:8080/async/2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity getResponse = restTemplate.getForEntity(getUrl, Image.class);

        if(getResponse.getBody() != null){
            Image image = (Image) getResponse.getBody();
            UtilBase64Image.decoder(image.getData(), "src/main/resources/images/" + image.getName() +".jpg");
            System.out.println("Done!");
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }*/



}
