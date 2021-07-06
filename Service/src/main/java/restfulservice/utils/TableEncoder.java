package restfulservice.utils;

import tech.tablesaw.api.Table;

import java.util.*;

public class TableEncoder {
    public TableEncoder() {
    }

    public Map<String, List<String>> encode(Table t){
        List<String> colsList = t.columnNames();
        int rowCount = t.rowCount();
        int colCount = t.columnCount();

        Map<String,List<String>> map = new LinkedHashMap<>();

        //add cols as keys
        for (int i = 0; i < colCount; i++) {
            List<String> L = new ArrayList<>();
            map.put(colsList.get(i),L);
        }

        //add rows
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String s = t.get(i,j).toString();
                map.get(colsList.get(j)).add(s);
            }
        }
        return map;
    }
}
