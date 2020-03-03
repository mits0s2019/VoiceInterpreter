package com.company.utils;

import java.util.Iterator;
import java.util.Map;

public class PrintingMap<K,V> {

    private Map<K, V> map;

    public PrintingMap(Map<K, V> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<K, V> entry = iter.next();
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append("[phone number : ");
            sb.append(entry.getValue());
            sb.append(']');
            if (iter.hasNext()) {
                sb.append("\n");
            }
        }
        return sb.toString();

    }
}
