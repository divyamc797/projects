package com.divya.jwtservice;

public class LongestPalindromicSubstring {
    public static void main(String args[]) {
        final String str = "aaaabbaacc";
        //out put: 6 (length of palindrome aabbaa)

        //solution
        int[][] dp = new int[str.length()][str.length()];

        //length 1
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }

        //length 2
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = 1;
            }
        }

        int max = 1;

        //for any length
        for (int j = 2; j < str.length(); j++) {
            for (int i = 0; i < str.length() - 2; i++) {
                if (str.charAt(i) == str.charAt(j)
                        && dp[i + 1][j - 1] == 1) {
                    if ((j - i) + 1 > max)
                        max = (j - i) + 1;

                    dp[i][j] = 1;
                }
            }
        }

        System.out.println(max);
    }
}