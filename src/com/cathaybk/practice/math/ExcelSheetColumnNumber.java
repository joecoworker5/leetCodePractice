package com.cathaybk.practice.math;


public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int titleNumber = 0;
        for(int i=0; i<columnTitle.length(); i++){
            int c = (int)columnTitle.charAt(columnTitle.length()-1-i) - 64;
            titleNumber += c * Math.pow(26,i);
        }

        return titleNumber;
    }
}
