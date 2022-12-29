package com.cathaybk.practice.twoPointer;

public class LongestPalindromicSubstring {

    String longestString = "";
    public String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        for(int i=0; i<s.length(); i++){
            findLongest(i,i, s);
            findLongest(i,i+1, s);
        }

        return longestString;
    }

    void findLongest(int left, int right, String s){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        longestString = longestString.length() < (right - left -1) ? s.substring(left+1, right) : longestString;
    }

}
