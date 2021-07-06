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



}
