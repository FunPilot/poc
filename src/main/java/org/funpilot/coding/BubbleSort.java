package org.funpilot.coding;

public class BubbleSort {

    public int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int i=0; i<arr.length; ++i) {
            for (int j=0; j<arr.length-i-1; ++j) {
                if (arr[j] > arr[j+1]) {
                    int swap = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = swap;
                }
            }
        }
        return arr;
    }

    public void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort ins = new BubbleSort();
        ins.print(ins.sort(new int[] {3,2,5,1,4}));
        ins.print(ins.sort(new int[] {1,2,3,4,5}));
        ins.print(ins.sort(new int[] {5,4,3,2,1}));
        ins.print(ins.sort(new int[] {5,3,3,3,4}));
        ins.print(ins.sort(new int[] {9,-3,-1,0,5}));
        ins.print(ins.sort(new int[] {Integer.MAX_VALUE,-3,Integer.MIN_VALUE,0,5}));
    }
}
