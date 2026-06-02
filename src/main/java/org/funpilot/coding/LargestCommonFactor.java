package org.funpilot.coding;

import java.util.HashMap;
import java.util.Map;

public class LargestCommonFactor {

    public Map<Integer, Integer> factor(int num) {
        Map<Integer, Integer> factor = new HashMap<>();
        int remain = num;
        boolean isPrime = false;
        while(!isPrime) {
            isPrime = true;
            //System.out.println("remain:" + remain);
            for (int i=2; i<=Math.sqrt(remain); ++i) {
                if (remain % i == 0) {
                    if (factor.containsKey(i)) {
                        factor.put(i, factor.get(i)+1);
                    } else {
                        factor.put(i, 1);
                    }
                    remain = remain / i;
                    isPrime = false;
                    break;
                }
            }
        }
        if (factor.containsKey(remain)) {
            factor.put(remain, factor.get(remain)+1);
        } else {
            factor.put(remain, 1);
        }
        return factor;
    }

    public int lcm(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);

        Map<Integer, Integer> lcm = new HashMap<>();
        Map<Integer, Integer> factor1 = factor(n1);
        //printMap(factor1);
        Map<Integer, Integer> factor2 = factor(n2);
        //printMap(factor2);
        for (Map.Entry<Integer, Integer> e : factor1.entrySet()) {
            Integer key = e.getKey();
            if (factor2.containsKey(key)) {
                int cnt = e.getValue() < factor2.get(key) ? e.getValue() : factor2.get(key);
                lcm.put(key, cnt);
            }
        }
        int result = 1;
        for (Map.Entry<Integer, Integer> e : lcm.entrySet()) {
            result = result * (int)Math.pow(e.getKey(), e.getValue());
        }
        return result;
    }

    public void printMap(Map<Integer, Integer> input) {
        for (Map.Entry<Integer, Integer> e : input.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }

    public static void main(String[] args) {
        LargestCommonFactor ins = new LargestCommonFactor();
        System.out.println(ins.lcm(6, 9));
        System.out.println(ins.lcm(24, 40));
        System.out.println(ins.lcm(2, 8));
        System.out.println(ins.lcm(8, 32));
        System.out.println(ins.lcm(11, 121));
        System.out.println(ins.lcm(27, 27));
        System.out.println(ins.lcm(1, 10));
        System.out.println(ins.lcm(17, 21));

        System.out.println("Test -ve cases");
        System.out.println(ins.lcm(-8, 32));
        System.out.println(ins.lcm(8, -32));
        System.out.println(ins.lcm(-8, -32));
    }
}
