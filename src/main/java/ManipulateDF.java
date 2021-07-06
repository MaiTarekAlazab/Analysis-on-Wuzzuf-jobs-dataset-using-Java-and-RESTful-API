import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import tech.tablesaw.aggregate.Summarizer;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import java.util.function.Function;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ManipulateDF {
    private Table t;
    private Table t_clean;
    public ManipulateDF(String filename) throws IOException {
        try {

            t = Table.read().csv(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayData(){
        System.out.println(t.first(10));

    }

    public void displayStructure(){
        System.out.println(t.structure());
        System.out.println(t.summary());
    }

    public void cleanDataframe(){
        Table t_temp = t.dropRowsWithMissingValues();
        t_clean = t_temp.dropDuplicateRows();
        System.out.println("Shape of the original dataframe "+t.shape());
        System.out.println("Shape of the cleaned dataframe "+ t_clean.shape());

    }

    private Map<String, Long> getSortedMap(List<String> l) {
        Map<String, Long> frequencyMap =
                l.stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        Map<String, Long> frequencyMapSorted = frequencyMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        return frequencyMapSorted;
    }

    private void aggCompanies(Map<String,Long> map){
        StringColumn mappedCompanyColumn = null;
        StringColumn company = (StringColumn) t_clean.column ("Company");
        List<String> mappedCompanyValues = new ArrayList<String> ();
        for (String c : company) {
            if (map.get(c)<15){
                mappedCompanyValues.add("Other");
            } else { mappedCompanyValues.add (c); }
            }
        mappedCompanyColumn = StringColumn.create ("Company_agg", mappedCompanyValues);
        t_clean.addColumns (mappedCompanyColumn);
        }





    public void generatePieChart(String col){

            Map<String, Long> MapSorted = getSortedMap(t_clean.stringColumn(col).asList());
            if (t_clean.columnNames().contains("Company_agg") == false){
                aggCompanies(MapSorted);
             }
            if (col =="Company"){
                MapSorted = getSortedMap(t_clean.stringColumn("Company_agg").asList());
            }
            PieChart pie = new PieChartBuilder().width(1100).height(600).title("Pie Chart of number of jobs from each company").build();
            MapSorted.forEach((k, v) -> pie.addSeries(k, v));
            pie.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
            pie.getStyler().setHasAnnotations(true);
            new SwingWrapper(pie).displayChart();
            System.out.println("The number of jobs from each company:");
            System.out.println(MapSorted);
    }

    public void generateBarChart ( String col, String graphTitle, String xLabel,String yLabel) {
        Map<String, Long> frequencyMapSorted = getSortedMap(t_clean.stringColumn(col).asList()).entrySet().stream().limit(10).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        ArrayList<String> keyList = new ArrayList<String>(frequencyMapSorted.keySet());
        ArrayList<Long> valueList = new ArrayList<Long>(frequencyMapSorted.values());
        CategoryChart chart = new CategoryChartBuilder().height(600).width(1800).xAxisTitle(xLabel).yAxisTitle(yLabel).title(graphTitle).build();
        chart.addSeries(graphTitle, keyList, valueList);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        new SwingWrapper(chart).displayChart();
        System.out.println("The most popular job " + col.toLowerCase() + "s:");
        System.out.println(frequencyMapSorted);
    }

    public void getSkills(Integer i){
        // input is the number of skills that the client want to see
        List<String> skills = t_clean.stringColumn("skills").asList().stream().
                flatMap(row-> Arrays.stream(row.split(","))).collect(Collectors.toList());
        Map<String, Long> frequencyMap = getSortedMap(skills).entrySet().stream().limit(i).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));;
        System.out.println("Most important required skills: ");
        for (Map.Entry<String, Long> entry: frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
    public void factorizeYears(){
        Map<Integer,Integer> yearsMap  =new HashMap<Integer,Integer>();
        StringColumn yearsExp = (StringColumn) t_clean.column ("YearsExp");
        List<Number > yearValues = new ArrayList<Number> ();
        Integer index = 0;
        for (String v : yearsExp) {
            Integer temp = null;
            if (v.replaceAll("[^0-9]", "")== ""){
                temp =0;
            }else{ temp = Integer.parseInt(v.replaceAll("[^0-9]", "")); }
            if (yearsMap.containsKey(temp)==false){
                yearsMap.put(temp,index);
                yearValues.add(index);
                index +=1;
            }
            else{ yearValues.add(yearsMap.get(temp)); }
        }

        DoubleColumn yearsColumn = DoubleColumn.create("factorized years", yearValues);
        t_clean.addColumns (yearsColumn);
        System.out.println(t_clean.first(10));
    }


    }
