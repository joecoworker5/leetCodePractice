package com.cathaybk.practice.sort;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if(nums==null || nums.length == 0){
            return "";
        }
        String[] snums = new String[nums.length];
        for(int i=0; i<snums.length; i++){
            snums[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(snums, (s1,s2)->{
            String combine1 = s1+s2;
            String combine2 = s2+s1;
            return combine2.compareTo(combine1);
        });

        StringBuilder sb = new StringBuilder();
        for(String s: snums){
            sb.append(s);
        }

        if("0".equals(snums[0])){
            return "0";
        }

        return sb.toString();
    }
}
