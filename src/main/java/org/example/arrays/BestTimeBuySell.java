package org.example.arrays;


/*
    given an array prices where prices[i] is the price of a stock on day i.
    You want to maximize your profit by choosing one day to buy and one different day in the future to sell.
    Return the maximum profit you can achieve.
    If you cannot achieve any profit, return 0.
 */
public class BestTimeBuySell {
    public static void main(String[] args) {
        var array = new int[]{7,1,5,3,6,4};

        var bestTimeBuySell = bruteForceCalculate(array);
        System.out.println(bestTimeBuySell);
    }

    private static int bruteForceCalculate(int[] array) {
        var bestProfit=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j]-array[i]>bestProfit) {
                    bestProfit=array[j]-array[i];
                }
            }
        }
        return bestProfit;
    }


    private static int calculateMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int bestProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // found a new minimum
            } else if (price - minPrice > bestProfit) {
                bestProfit = price - minPrice; // found a better profit
            }
        }

        return bestProfit;
    }
}
