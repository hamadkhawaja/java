package com.company;

/**
 * Created by Hamad on 27/04/2015.
 */
public class ArraysAndStrings {
    public String stringConpressString(String str) {
        String retVal = "";
        char previousElement = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == previousElement) {
                count++;
            }
            else
            {
                retVal += previousElement + "" + count;
                previousElement = str.charAt(i);
                count = 1;
            }
        }

        if (str.length() == retVal.length()) {
            return str;
        }

        return retVal;
    }

    public void setZeros(int [][]matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
