package restfulservice.controller;

import restfulservice.model.ManipulateDF;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import restfulservice.utils.JSONEncoder;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import restfulservice.model.ManipulateDF;
import restfulservice.utils.TableEncoder;

@RestController
@RequestMapping("/data")
public class ModelController {

    ManipulateDF mDF;

    public ModelController() throws IOException {
        mDF = new ManipulateDF("src/main/resources/Wuzzuf_Jobs.csv");
    }

    @GetMapping(value = "/test")
    public String test()  throws IOException {
        return "Hello";
    }

    @GetMapping(value = "/disdata")
    public String getDisplayData()  throws IOException {
        Table t = mDF.displayDataAsTable();
        //encoding
        TableEncoder Tencoder = new TableEncoder();
        JSONEncoder Jencoder = new JSONEncoder();
        Map<String, List<String>> map = Tencoder.encode(t);
        String toSend = Jencoder.covertFromObjectToJson(map);
        return toSend;
    }

    @GetMapping(value = "/structure")
    public String getDataStructure()  throws IOException {
        Table t = mDF.displayStructure();

        //encoding
        TableEncoder Tencoder = new TableEncoder();
        JSONEncoder Jencoder = new JSONEncoder();
        Map<String, List<String>> map = Tencoder.encode(t);
        String toSend = Jencoder.covertFromObjectToJson(map);
        return toSend;
    }

    @GetMapping(value = "/summary")
    public String getDataSummary()  throws IOException {
        Table t = mDF.displaySummary();
        //encoding
        TableEncoder Tencoder = new TableEncoder();
        JSONEncoder Jencoder = new JSONEncoder();
        Map<String, List<String>> map = Tencoder.encode(t);
        String toSend = Jencoder.covertFromObjectToJson(map);
        return toSend;
    }

    //unfinished
    @GetMapping(value = "/clean")
    public void getCleanData()  throws IOException {
        Table t = mDF.getT();
        Table t_clean = mDF.getT_clean();

        System.out.println("Shape of the original dataframe "+t.shape());
        System.out.println("Shape of the cleaned dataframe "+ t_clean.shape());
                //encoding
        //TableEncoder Tencoder = new TableEncoder();
        //JSONEncoder Jencoder = new JSONEncoder();
        //Map<String, List<String>> map = Tencoder.encode(t);
        //String toSend = Jencoder.covertFromObjectToJson(map);
        //return toSend;
    }

    @GetMapping(value = "/job")
    public Map<String, Long> getJobCounted()  throws IOException {
        Table t_clean = mDF.getT_clean();
        Map<String, Long> map = mDF.getJobCount();
        return map;
    }

    @GetMapping(value = "/titles")
    public Map<String, Long> getJobTitles()  throws IOException {
        Table t_clean = mDF.getT_clean();
        Map<String, Long> map = mDF.getTitles();
        return map;
    }
    @GetMapping(value = "/areas")
    public Map<String, Long> getJobAreas()  throws IOException {
        Table t_clean = mDF.getT_clean();
        Map<String, Long> map = mDF.getAreas();
        return map;
    }



}
