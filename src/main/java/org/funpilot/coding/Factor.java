package org.funpilot.coding;

import java.util.ArrayList;
import java.util.List;

public class Factor {

    public List<Integer> factor(int num) {
        List<Integer> result = new ArrayList<>();
        if (num == 0) {
            return result;
        }
        if (num < 0) {  // simplify for -ve, shall consist of +ve * +ve and -ve * -ve factors
            num = -num;
        }
        int mid = (int)Math.sqrt(num);
        for (int i=2; i<=mid; ++i) {
            int remain = num % i;
            if (remain == 0) {
                result.add(i);
                result.add(num / i);
            }
        }
        return result;
    }

    public void printList(List<Integer> numList) {
        if (numList.isEmpty()) {
            System.out.println("Prime number.");
            return;
        }
        for (Integer i : numList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Factor ins = new Factor();
        ins.printList(ins.factor(0));
        ins.printList(ins.factor(1));
        ins.printList(ins.factor(2));
        ins.printList(ins.factor(3));
        ins.printList(ins.factor(4));
        ins.printList(ins.factor(8));
        ins.printList(ins.factor(36));
        ins.printList(ins.factor(38));
        ins.printList(ins.factor(56));
        ins.printList(ins.factor(-2));
        ins.printList(ins.factor(-9));
        ins.printList(ins.factor(-13));
        ins.printList(ins.factor(-15));
    }
}
