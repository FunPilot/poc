package org.funpilot.coding;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] a1 = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] a2 = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeSortedArr(a1, a2);
    }

    private int[] mergeSortedArr(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        int pos1 = 0;
        int pos2 = 0;
        int k = 0;
        while (k < merged.length) {
            // a1 is done, put remaining elements in a2
            if (pos1 >= a1.length) {
                merged[k] = a2[pos2];
                k++;
                pos2++;
                continue;
            }
            // a2 is done, put remaining elements in a1
            if (pos2 >= a2.length) {
                merged[k] = a1[pos1];
                k++;
                pos1++;
                continue;
            }
            // put smaller element in merged arr
            if (a1[pos1] <= a2[pos2]) {
                merged[k] = a1[pos1];
                k++;
                pos1++;
            } else {
                merged[k] = a2[pos2];
                k++;
                pos2++;
            }
        }
        return merged;
    }

    public void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort ins = new MergeSort();
        ins.print(ins.sort(new int[] {3,2,5,1,4}));
        ins.print(ins.sort(new int[] {1,2,3,4,5}));
        ins.print(ins.sort(new int[] {5,4,3,2,1}));
        ins.print(ins.sort(new int[] {5,3,3,3,4}));
        ins.print(ins.sort(new int[] {9,-3,-1,0,5}));
        ins.print(ins.sort(new int[] {Integer.MAX_VALUE,-3,Integer.MIN_VALUE,0,5}));
    }
}

