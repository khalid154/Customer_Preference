package com.customer.pereference.util;

import java.util.List;

public class StringUtil {

    public static String getStringFromIntegerList(List<Long> longs) {
        if (longs == null) return null;
        String str = "";
        for (int i = 0; i < longs.size(); i++) {
            if (i > 0) {
                str += ",";
            }
            str += longs.get(i);
        }
        return str;
    }

    public static String getStringFromList(List<String> strs) {
        if (strs == null) return null;
        String str = "";
        for (int i = 0; i < strs.size(); i++) {
            if (i > 0) {
                str += ",";
            }
            str += strs.get(i);
        }
        return str;
    }
}
