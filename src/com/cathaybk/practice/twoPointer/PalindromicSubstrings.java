package com.cathaybk.practice.twoPointer;

public class PalindromicSubstrings {
    int count = 0;
    public int countSubstrings(String s) {
        if(s.length()==1){
            return 1;
        }

        for(int i=0; i<s.length(); i++){
            find(i, i, s);
            find(i, i+1, s);
        }

        return count;
    }

    void find(int left, int right, String s){
        while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
    }
}
