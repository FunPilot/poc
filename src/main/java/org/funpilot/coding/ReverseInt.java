package org.funpilot.coding;

public class ReverseInt {

    public int reverse(int input) {
        // handle -ve
        int sign = 1;
        if (input < 0) {
            input = -input;
            sign = -1;
        }

        int result = 0;
        while (input > 0) {
            int remain = input % 10;
            result = result * 10 + remain;
            input = input / 10;
        }

        result = result * sign;
        if (result != 0 && sign != Integer.signum(result)) {
            System.out.println("Reverse value overflow");
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseInt().reverse(12345));
        System.out.println(new ReverseInt().reverse(225599));
        System.out.println(new ReverseInt().reverse(12340));  // 04321 = 4321
        System.out.println(new ReverseInt().reverse(0));
        System.out.println(new ReverseInt().reverse(-12345));
        System.out.println(new ReverseInt().reverse(2147483641));
        System.out.println(new ReverseInt().reverse(Integer.MAX_VALUE));
        System.out.println(new ReverseInt().reverse(Integer.MIN_VALUE + 1));
    }
}

