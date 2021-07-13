package com.duylv.springdiscovery.util;

import java.util.Arrays;

public class StringUtil {

    public static String concentrateString(String... str) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(str).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
