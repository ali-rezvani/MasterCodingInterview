package org.example.arrays;

public class TowSumArray {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,3,9,7,5,2};
        int target = 11;
        Integer P1 = null, P2 = null;
        for (int i = 0; i < array.length-1; i++) {
            if (P2 != null) {
                break;
            }
            P1=array[i];
            int t=target-P1;
            for(int j=i+1;j<array.length;j++){
                if (array[j]==t){
                    P2=array[j];
                    System.out.println("Index1="+i+" Index2="+j);
                    break;
                }
            }
        }

        System.out.println("P1="+P1+" P2="+P2);
    }
}
