package com.cathaybk.practice.dp;

public class MinimumValuetoGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minStartValue = 0;
        for(int num : nums){
            sum += num;
            if(sum<=0){
                minStartValue += 1-sum;
                sum = 1;
            }
        }

        return minStartValue == 0 ? 1 : minStartValue;
    }
}
