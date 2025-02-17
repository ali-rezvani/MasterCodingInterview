package org.example.integers;

public class ReverseInteger {
    public static void main(String[] args) {
        int integer = -85778345;
        System.out.println(reverse(integer));
    }


    private static int reverse(int x) {
        var reversed = 0;
        var min = Integer.MIN_VALUE;
        var max = Integer.MAX_VALUE;
        while (x != 0) {
            var lastDigit = x % 10;
            if (reversed > 0 || (reversed == max / 10 && lastDigit > 7)) {
                return 0;
            }
            if (reversed < min || (reversed == min / 10 && lastDigit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + lastDigit;
            x = x / 10;
        }

        return reversed;
    }
}
