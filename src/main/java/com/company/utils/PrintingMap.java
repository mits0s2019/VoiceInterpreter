package com.company.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * PrintingMap is a map in order to print the final result
 */

public class PrintingMap<K,V> {

    private Map<K, V> map;

    public PrintingMap(Map<K, V> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();
        int i=1;
        while (iter.hasNext()) {

            Map.Entry<K, V> entry = iter.next();
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
