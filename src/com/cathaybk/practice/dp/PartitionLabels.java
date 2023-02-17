package com.cathaybk.practice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {


	// https://leetcode.com/problems/partition-labels/solutions/1868842/java-c-visually-explaineddddd/
	public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int index=0; index < s.length(); index++){
            char c = s.charAt(index);
            map.put(c, index);
        }

        int max = map.get(s.charAt(0)); int prev = -1;
        List<Integer> result = new ArrayList<>();
        for(int index = 0; index < s.length()+1; index++){
            if(index==s.length()+1){
                result.add(max-prev);
            }
            if(index>max){
                result.add(max-prev);
                prev = max;
                max = map.get(s.charAt(index));
            }
            Integer maxIndex = map.get(s.charAt(index));
            max = Math.max(max, maxIndex);
        }

        return result;
    }
}
