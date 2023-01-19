package com.cathaybk.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l1  = Arrays.stream(nums1)
              .boxed()
              .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for(int num2: nums2){
            if(l1.contains(num2)){
                result.add(num2);
                l1.remove((Integer) num2);
            }
        }

        int[] resultArr = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            resultArr[i]=result.get(i);
        }
        return resultArr;
    }

}
