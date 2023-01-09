package com.divya.learning.examples.leetcodequestions;

import java.util.*;

public class Domain {

    public static void main(String[] args) {
        String[] counts = {"50,google.co.in", "100,yahoo.co.in"};
        /*
        google.co.in -> 50
        co.in -> 150
        in -> 150
        yahoo.co.in -> 100
         */

        System.out.println(getCountsWithSubDomain(counts));


    }

    static Map<String, Integer> getCountsWithSubDomain(String[] counts) {
        Map<String, Integer> integerStringMap = new HashMap<>();
        for (String count : counts) {
            String[] splitRes = count.split("\\,");
            int cnt = Integer.parseInt(splitRes[0]);
            for (String subD : getSubDomains(splitRes[1])) {
                if (!integerStringMap.containsKey(subD)) {
                    integerStringMap.put(subD, cnt);
                } else {
                    integerStringMap.put(subD, integerStringMap.get(subD) + cnt);

                }

//                integerStringMap.put(subD, integerStringMap.getOrDefault(subD, 0) + cnt);
            }
        }
        return integerStringMap;

    }

    //["google.co.in", "co.in", "in"]
    static List<String> getSubDomains(String domain) {
        List<String> subDomains = new ArrayList<>();
        subDomains.add(domain); //["google.co.in"]
        String[] split = domain.split("\\."); //["google","co","in"]
        List<String> strings = new ArrayList<>();
        for(String s : split) {
            strings.add(s);
        }
        strings.remove(0); //["co","in"]

        while (strings.size() > 0) {
            subDomains.add(String.join(".", strings));
            strings.remove(0);
        }

        return subDomains;
    }
}
