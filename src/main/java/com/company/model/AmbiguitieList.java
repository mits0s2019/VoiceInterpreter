package com.company.model;

import java.util.*;

public class AmbiguitieList {

    private static Set<String> ambiguities = new TreeSet<>();

    public static Set<String> getAmbiguities() {
        return ambiguities;
    }

}
