package restfulservice.controller;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import restfulservice.model.ManipulateDF;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import restfulservice.utils.Base64ImageEncoder;
import restfulservice.utils.Image;
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


    @RequestMapping(value = "/pie")

    public Image  getpie() throws IOException {
        Table t_clean = mDF.getT_clean();
        System.out.println("this is the funtion of gen pie");
        mDF.generatePieChart("Company");
        String imagePath1 = "src/main/resources/Sample1.png";
        String imageBase64 = Base64ImageEncoder.encoder(imagePath1);

        if(imageBase64 != null){
            Image image1 = new Image("pie", imageBase64);
            return image1;
        }
        return null;

    }
    @RequestMapping(value = "/bar1")

    public Image getbar1() throws IOException {
        Table t_clean = mDF.getT_clean();
        System.out.println("this is the funtion of gen bar1");
        mDF.generateBarChart("Title","Top 10 popular jobs","Sample2","Jobs", "Frequency of jobs");
        String imagePath2 = "src/main/resources/Sample2.png";
        String imageBase64 = Base64ImageEncoder.encoder(imagePath2);

        if(imageBase64 != null){
            Image image2 = new Image("bar1", imageBase64);
            return image2;
        }
        return null;


    }

    @RequestMapping(value = "/bar2")

    public Image getbar2() throws IOException {
        Table t_clean = mDF.getT_clean();
        System.out.println("this is the funtion of gen bar2");
        mDF.generateBarChart("Title","Top 10 popular jobs","Sample3","Jobs", "Frequency of jobs");
        String imagePath3 = "src/main/resources/Sample3.png";
        String imageBase64 = Base64ImageEncoder.encoder(imagePath3);

        if(imageBase64 != null){
            Image image3 = new Image("bar2", imageBase64);
            return image3;
        }
        return null;


    }





}
