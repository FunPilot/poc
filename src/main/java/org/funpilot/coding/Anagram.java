package org.funpilot.coding;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public boolean isAnaGram(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        Map<Character, Integer> m1 = occurcentMap(s1.toLowerCase());
        Map<Character, Integer> m2 = occurcentMap(s2.toLowerCase());
        return compareMap(m1, m2);
    }

    private Map<Character, Integer> occurcentMap(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            // ignore space
            if (c == ' ') {
                continue;
            }
            if (result.containsKey(c)) {
                Integer cnt = result.get(c);
                result.put(c, ++cnt);
            } else {
                result.put(c, 1);
            }
        }
        return result;
    }

    private boolean compareMap(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.isEmpty() || m2.isEmpty()) {
            return false;
        }
        if (m1.size() != m2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> e : m1.entrySet()) {
            if (m2.containsKey(e.getKey()) && e.getValue().equals(m2.get(e.getKey()))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Anagram().isAnaGram("abcde", "dcbae"));
        System.out.println(new Anagram().isAnaGram("abcde", "dcbad"));
        System.out.println(new Anagram().isAnaGram("New York Times", "monkeys write"));
        System.out.println(new Anagram().isAnaGram("McDonald's restaurants", "Uncle Sam's standard rot"));
    }
}

