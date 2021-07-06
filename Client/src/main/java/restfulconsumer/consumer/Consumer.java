package restfulconsumer.consumer;
import restfulconsumer.utils.Image;
import restfulconsumer.utils.UtilBase64Image;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consumer {
    public static void getHello()
    {
        final String uri = "http://localhost:8080/";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);

        //Use the response
        System.out.println(result);
    }
    public static void getdf()
    {
        final String uri = "http://localhost:8080/test";
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        Table t = restTemplate.getForObject(uri, Table.class);
        System.out.println(t.structure());

        //Use the response

    }

    public static void getpic() throws IOException {
        final String uri = "http://localhost:8080/async/sync-img";
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<byte[]> r = restTemplate.getForEntity(uri, byte[].class);

        //Use the response

    }

    /*public static void getTestConsume() throws IOException {
        final String uri = "http://localhost:8080/consume";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        List<String> t = JSONUtils.covertFromJsonToObject(result, List.class);
        System.out.println(t);
    }

    public static void getImg() {
        String getUrl = "http://localhost:8080/async/2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity getResponse = restTemplate.getForEntity(getUrl, Image.class);

        if(getResponse.getBody() != null){
            Image image = (Image) getResponse.getBody();
            UtilBase64Image.decoder(image.getData(), "src/main/resources/rec/" + image.getName() +".jpp");
            System.out.println("Done!");
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }*/
}
