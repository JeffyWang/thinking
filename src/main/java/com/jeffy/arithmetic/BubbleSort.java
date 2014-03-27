package com.jeffy.arithmetic;

public class BubbleSort {
    public static void main(String[] args) {
        int[] num = {9,5,4,3,2,7,6,1};
        for(int i = 0; i < num.length; i ++) {
            for(int j = i + 1; j < num.length; j ++) {
                for(int n : num) {
                    System.out.print(n + ",");
                }
                System.out.println();
                int tmp;
                if(num[i]>num[j]) {
                    tmp = num[j];
                    num[j] = num[i];
                    num[i] = tmp;
                }
            }
        }
        System.out.println("###########################################################");
        for(int n : num) {
            System.out.print(n + ",");
        }
    }
}