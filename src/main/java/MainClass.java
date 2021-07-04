import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        ManipulateDF df = new ManipulateDF("src/main/resources/Wuzzuf_Jobs.csv");
        df.displayData();
        df.displayStructure();
        df.cleanDataframe();
        df.generatePieChart("Company");
        df.generateBarChart ("Title","Top 10 popular jobs","Jobs", "Frequency of jobs");
        df.generateBarChart ("Location","Top 10 popular areas","Area", "Number of jobs in the area");
        df.getSkills(10);


    }

}
