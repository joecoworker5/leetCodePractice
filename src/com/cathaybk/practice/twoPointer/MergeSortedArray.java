package com.cathaybk.practice.twoPointer;

import java.util.Arrays;

public class MergeSortedArray {
   // time complexity: O((M+n)Log(M+M)
    // space complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for(int i=0; i<nums1.length; i++){
            if(i>=m){
                nums1[i]=nums2[index++];
            }
        }

        Arrays.sort(nums1);
    }

    // time complexity: O(m+n)
    // space complexity: O(1)
    public void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m-1;
        int end2 = n-1;
        int newEnd = m+n-1;
        while(end2>=0){
            if(end1<0 || nums1[end1]<nums2[end2]){
                nums1[newEnd] = nums2[end2];
                newEnd--;
                end2--;
            } else {
                nums1[newEnd] = nums1[end1];
                newEnd--;
                end1--;
            }
        }
    }
}
