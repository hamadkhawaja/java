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
}
