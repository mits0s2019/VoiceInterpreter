package com.company.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * PrintingMap is a map in order to print the final result
 */

public class PrintingMap {

    private Map<String,String> map;

    public PrintingMap(Map<String,String> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        int i=1;
        while (iter.hasNext()) {

            Map.Entry<String,String> entry = iter.next();
            sb.append("Interpretation "+i+" : ");
            sb.append(entry.getKey());
            sb.append("\t\t\t");
            sb.append("[phone number : ");
            sb.append(entry.getValue());
            sb.append(']');

            if (iter.hasNext()) {
                sb.append("\n");
                i++;
            }
        }
        return sb.toString();

    }
}
