package restfulconsumer.utils;

import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;
import tech.tablesaw.api.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TableDecoder {
    public TableDecoder() {
    }

    public Table decode(Map<String, List<String>> map) throws IOException {
        String eol = System.getProperty("line.separator");

        try (Writer writer = new FileWriter("src/main/resources/csvfiles/structure.csv")) {
            int count = 0;
            List<String> keys = map.keySet().stream().collect(Collectors.toList());
            int colCount = keys.size();
            for (int i = 0; i < colCount; i++) {
                if (count != 0)
                    writer.append(',');
                writer.append(keys.get(i));
                count++;
            }
            writer.append(eol);

            count = 0;
            List<List<String>> values = map.values().stream().collect(Collectors.toList());
            int rowCount = values.get(0).size();

            for (int i = 0; i < rowCount ; i++) {
                for (int j = 0; j < colCount ; j++) {
                    if (count != 0)
                        writer.append(',');
                    writer.append(values.get(j).get(i));
                    count++;
                }
                count = 0;
                writer.append(eol);
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        Table t = Table.read().csv("src/main/resources/csvfiles/structure.csv");
        return t;
    }
}
