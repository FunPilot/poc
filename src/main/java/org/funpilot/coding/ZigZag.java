package org.funpilot.coding;

public class ZigZag {
    public String convert(String s, int row) {
        if (row == 1 || row <= 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<row; ++i) {
            int col = row - 1;
            int dia = row - 2;
            int increment = col + dia + 1;
            int j = i;
            while (j < s.length()) {
                result.append(s.charAt(j));
                System.out.println(i + "," + j + "," + s.charAt(j));
                if (i != 0 && i != row-1) {
                    int x = j+(row-1-i) *2;
                    if (x > 0 && x < s.length()) {
                        //System.out.println("x: " + x + "," + s.charAt(x));
                        result.append(s.charAt(x));
                    }
                }
                j += increment;
            }
            System.out.println("row:" + i + ", s:" + result.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZag ins = new ZigZag();
        System.out.println(ins.convert("PAYPALISHIRING", 3));
        System.out.println(ins.convert("PAYPALISHIRING", 4));
    }
}
