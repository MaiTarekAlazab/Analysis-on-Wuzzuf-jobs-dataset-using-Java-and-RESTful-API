package restfulservice.utils;

import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableEncoder {
    public TableEncoder() {
    }

    public Map<String, List<String>> encode(Table t){
        List<String> structureList = t.columnNames();
        int rowCount = t.rowCount();
        int colCount = t.columnCount();

        Map<String,List<String>> map = new HashMap<>();

        //add cols as keys
        for (int i = 0; i < colCount; i++) {
            List<String> L = new ArrayList<>();
            map.put(structureList.get(i),L);
        }

        //add rows
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String s = t.get(i,j).toString();
                map.get(structureList.get(j)).add(s);
            }
        }

        return map;
    }
}
