package restfulservice.controller;

import restfulservice.model.ManipulateDF;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import tech.tablesaw.api.Table;

import java.io.IOException;

public class ModelController {

    @GetMapping(value = "/test")
    public Table df()  throws IOException {
        ManipulateDF df = new ManipulateDF("src/main/resources/Wuzzuf_Jobs.csv");
        Table t = Table.read().csv("src/main/resources/Wuzzuf_Jobs.csv");
        return t;
    }
}
