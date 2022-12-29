package com.cathaybk.practice.twoPointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            maxArea = Math.max(maxArea, (right-left) * Math.min(height[left], height[right]));
            if(height[left]> height[right]){
                right --;
            } else if(height[right]>height[left]){
                left++;
            } else {
                right --;
                left++;
            }
        }

        return maxArea;
    }
}
