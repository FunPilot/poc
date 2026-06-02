package org.funpilot.coding;

public class LongestPalindrome {

    public boolean isPalindrome(String input) {
        boolean result = true;
        int len = input.length();
        for (int i = 0; i<len/2; ++i) {
            if (input.charAt(i) != input.charAt(len-1-i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public String extract(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String sub = "";
        int len = input.length();
        for (int subLen = len; subLen>0; --subLen) {
            for (int start = 0; start < len - subLen + 1; ++start) {
                sub = input.substring(start, start + subLen);
                //System.out.println("start/end/sub:" + start  + ":" + subLen + ":" + sub);
                if (isPalindrome(sub)) {
                    return sub;
                }
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().extract("AAFABCBATWLDS"));
        System.out.println(new LongestPalindrome().extract("ZZZABCDCBA"));
        System.out.println(new LongestPalindrome().extract("ABCDE"));
        System.out.println(new LongestPalindrome().extract(""));
    }
}
