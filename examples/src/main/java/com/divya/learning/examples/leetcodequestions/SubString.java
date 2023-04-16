package com.divya.learning.examples.leetcodequestions;

import java.util.ArrayList;
import java.util.List;

public class SubString {

    public static void main(String args[]) {
        String s = "00110011";
        int total = 0;
        for (String sub : possibleSubString(s)) {
            total += isEqualNumberOf1s0s(sub);
        }
        System.out.println(total);
    }

    public static List<String> possibleSubString(String string) {
        List<String> possibleSubStr = new ArrayList<>();
        for (int i = 1; i <= string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (j + i <= string.length())
                    possibleSubStr.add(string.substring(j, j + i));
            }
        }
        return possibleSubStr;
    }

    public static int isEqualNumberOf1s0s(String sub) {
        int noOfZeros = 0;
        for (char c : sub.toCharArray()) {
            if (c == '0')
                noOfZeros++;
        }

        if (sub.length() % 2 == 0 && sub.length() / 2 == noOfZeros)
            return 1;

        return 0;
    }

}
