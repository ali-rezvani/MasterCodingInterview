package org.example.integers;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    private static void fizzBuzz(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("\tFizzBuzz");
            }else if (i % 3 == 0) {
                System.out.print("\tFizz");
            }else if (i % 5 == 0) {
                System.out.print("\tBuzz");
            }else {
                System.out.print("\t"+i);
            }
        }
    }
}
