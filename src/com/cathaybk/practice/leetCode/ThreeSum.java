package com.cathaybk.practice.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = { -2, 0, 0, 2, 2 };
        List<List<Integer>> threeSum = threeSum(nums);
        System.out.println(threeSum);
    }

    //sort + two pointer O(NlogN)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return finalList;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int leftpivot = i + 1;
            int rightpivot = nums.length - 1;
            while (rightpivot > leftpivot) {
                if (nums[rightpivot] + nums[leftpivot] == target) {
                    List<Integer> list = Arrays.asList(nums[i], nums[rightpivot], nums[leftpivot]);
                    finalList.add(list);
                    leftpivot++;
                    rightpivot--;
                } else if (nums[rightpivot] + nums[leftpivot] < target) {
                    leftpivot++;
                } else {
                    rightpivot--;
                }
                while (rightpivot >= 1 && rightpivot < nums.length - 1 && nums[rightpivot] == nums[rightpivot + 1]) {
                    rightpivot--;
                }
                while (leftpivot < nums.length - 1 && leftpivot > i + 1 && nums[leftpivot] == nums[leftpivot - 1]) {
                    leftpivot++;
                }

            }
        }

        return finalList;
    }
}
