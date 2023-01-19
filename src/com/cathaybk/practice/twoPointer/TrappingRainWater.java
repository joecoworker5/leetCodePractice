package com.cathaybk.practice.twoPointer;

public class TrappingRainWater {

    public int trap(int[] height) {
        // brute force
        /**
         * height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
         * index = i;
         * trap water at trapAti = Math.min(maxLeft, maxRight) - height[i]
         * sum of trap water = sum(trapAti);
         * Time complexity: O(N^2)
         */
        int trapWaterSum = 0;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = findMax(0, i - 1, height);
            int maxRight = findMax(i + 1, height.length - 1, height);
            int trapWater = Math.min(maxLeft, maxRight) - height[i];
            if (trapWater > 0) {
                trapWaterSum += trapWater;
            }
        }
        return trapWaterSum;
    }

    int findMax(int start,
                int end,
                int[] height) {
        int max = 0;
        while (start <= end) {
            max = Math.max(height[start], max);
            start++;
        }
        return max;
    }


    public int trapDP(int[] height) {
        // dp 先把 maxLeft, maxRight 計算好這樣就不用每個 index 重複算
        /**
         * height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
         * maxLeft= [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
         * maxRight=[3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
         * index = i;
         * trap water at trapAti = Math.min(maxLeft, maxRight) - height[i]
         * sum of trap water = sum(trapAti);
         * Time complexity: O(N)
         * Space complexity: O(2N)
         */
        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];
        for(int i=0; i<height.length; i++){
            if(i==0){
                maxLeftArr[i]=0;
            } else {
                maxLeftArr[i]= Math.max(maxLeftArr[i-1], height[i-1]);
            }
        }

        for(int i=height.length-1; i>=0; i--){
            if(i==height.length-1){
                maxRightArr[height.length-1]=0;
            } else {
                maxRightArr[i]= Math.max(maxRightArr[i+1], height[i+1]);
            }
        }

        int trapWaterSum = 0;
        for (int i = 0; i < height.length; i++) {
            int trapWater = Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
            if (trapWater > 0) {
                trapWaterSum += trapWater;
            }
        }
        return trapWaterSum;
    }


    public int trapTwoPointer(int[] height) {
        // dp 先把 maxLeft, maxRight 計算好這樣就不用每個 index 重複算
        /**
         * height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
         * maxLeft= [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
         * maxRight=[3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
         * index = i;
         * trap water at trapAti = Math.min(maxLeft, maxRight) - height[i]
         * sum of trap water = sum(trapAti);
         * Time complexity: O(N)
         * Space complexity: O(1)
         */

        int trapWaterSum = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length-1];
        int l = 1;
        int r = height.length -2;
        while(l<=r){
            if(maxLeft <= maxRight){
                maxLeft = Math.max(maxLeft, height[l]);
                trapWaterSum += maxLeft - height[l];
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r]);
                trapWaterSum += maxRight - height[r];
                r--;
            }
        }

        return trapWaterSum;
    }
}
