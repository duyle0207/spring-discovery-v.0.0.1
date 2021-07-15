package com.duylv.springdiscovery.util;

import java.util.Arrays;

public class StringUtil {

    public static String concentrateString(String... str) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(str).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static String customLikeKeyword(String keyword) {
        return "%" + keyword + "%";
    }

    public static String customStartWithKeyword(String keyword) {
        return keyword + "%";
    }

    public static String customEndWithKeyword(String keyword) {
        return "%" + keyword;
    }
}
