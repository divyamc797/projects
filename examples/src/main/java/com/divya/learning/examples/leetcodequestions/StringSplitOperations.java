package com.divya.learning.examples.leetcodequestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSplitOperations {
    public static void main(String[] args) {
        String[] counts = {"50,google.co.in", "100,yahoo.co.in"};
        /*
        google.co.in -> 50
        co.in -> 150
        in -> 150
        yahoo.co.in -> 100
         */
        System.out.println(getSubDomainCounts(counts));
    }

    //1. loop
    //2. split by ","
    //3. get all subdomains
    //4. add to map

    static Map<String, Integer> getSubDomainCounts(String[] counts) {
        Map<String, Integer> sudDomainCountMap = new HashMap<>();

        for (String domainCount : counts) {
            String[] split = domainCount.split("\\,");

            int noOfHits = Integer.parseInt(split[0]);
            List<String> subDomainsFromDomain = getSubDomainsFromDomain(split[1]);
            for (String subDomain : subDomainsFromDomain) {
                if (sudDomainCountMap.containsKey(subDomain)) {
                    int sum = sudDomainCountMap.get(subDomain) + noOfHits;
                    sudDomainCountMap.put(subDomain, sum);
                } else {
                    sudDomainCountMap.put(subDomain, noOfHits);
                }
            }
        }

        return sudDomainCountMap;
    }

    //"google.co.in"   -> "google.co.in" , "co.in" , "in"
    static List<String> getSubDomainsFromDomain(String domain) {
        List<String> listOfSubDomains = new ArrayList<>();
//        listOfSubDomains.add(domain);
        String[] splitResult = domain.split("\\.");
        List<String> listOfStrings = new ArrayList<>();
        for (String s : splitResult) {
            listOfStrings.add(s);
        }
//        listOfStrings.remove(0);
        for (; listOfStrings.size() > 0; ) {
            listOfSubDomains.add(String.join(".", listOfStrings));
            listOfStrings.remove(0);
        }
        return listOfSubDomains;
    }

}
