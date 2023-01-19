package com.cathaybk.practice.structureDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ShuffleanArray {

    int[] nums;
    int[] origin;
    Random r = new Random();
    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.origin = nums;
    }

    public int[] reset() {
        nums = origin;
        return nums;
    }

    public int[] shuffle() {
        int count = 0;
        int[] result = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        while(true){
            int index = r.nextInt(nums.length);
            if(!used[index]){
                used[index] = true;
                result[count++] = nums[index];
            }
            if(count==nums.length){
                return result;
            }
        }
    }
}
