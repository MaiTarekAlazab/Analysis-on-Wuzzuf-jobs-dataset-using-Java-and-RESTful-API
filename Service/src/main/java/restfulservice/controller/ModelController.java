package restfulservice.controller;

import restfulservice.model.ManipulateDF;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import tech.tablesaw.api.Table;

import java.io.IOException;

@RestController
public class ModelController {

    @GetMapping(value = "/test")
    public String test()  throws IOException {
        return "Hello";
    }
}
