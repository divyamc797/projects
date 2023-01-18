package com.divya.learning.examples.basic20;

public class Palindrome {

    public static void main(String[] args) {
        int s = 1222;
        System.out.println(isPalindrome(s));
    }

//    Step1: Convert the integer into string.
//    Step2: Point two variable at first and last indices of the string.
//    Step3: Compare the characters at those indices.
//    Step4: Update the variables.

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {

            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
