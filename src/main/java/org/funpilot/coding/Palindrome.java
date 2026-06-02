package org.funpilot.coding;

public class Palindrome {

    public boolean check(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        boolean result = true;
        int len = input.length();
        for (int i = 0; i<len/2; ++i) {
            // System.out.println("i:" + i + "," + input.charAt(i) + "," + input.charAt(len-1-i));
            if (input.charAt(i) != input.charAt(len-1-i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().check("H"));
        System.out.println(new Palindrome().check("BBAABB"));
        System.out.println(new Palindrome().check("AASRSAA"));
        System.out.println(new Palindrome().check("!@#$%$#@!"));

        System.out.println(new Palindrome().check("BBACBB"));
        System.out.println(new Palindrome().check(null));
        System.out.println(new Palindrome().check(""));
    }
}