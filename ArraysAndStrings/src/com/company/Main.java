package com.company;

public class Main {


    public static void main(String[] args) {
	// write your code here
        ArraysAndStrings arr = new ArraysAndStrings();
        System.out.println(arr.stringConpressString("aaabbbcAAbC"));

        int [][]array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = 1;
            }
        }

        array[1][1] = 0;
        arr.setZeros(array);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
