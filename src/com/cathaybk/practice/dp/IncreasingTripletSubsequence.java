package com.cathaybk.practice.dp;


public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        Integer maxSoFar = null;
        Integer minSoFar = Integer.MAX_VALUE;
        for(int num: nums){
            if(num<=minSoFar){
                minSoFar = num;
            } else {
                if(maxSoFar!= null && num> maxSoFar) return true;
                maxSoFar = num;
            }
        }
        return false;
    }

}
