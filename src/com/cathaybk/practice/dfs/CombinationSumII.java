package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        dfs(candidates, 0, target, r, result);
        return result;
    }

    void dfs(int[] candidate, int index, int target, List<Integer> r , List<List<Integer>> result ){
        if(target==0){
            result.add(new ArrayList<>(r));
        }
        if(target<0){
            return;
        }

        for(int i=index; i<candidate.length; i++){
            if(i>index && candidate[i]==candidate[i-1]){
                continue;
            }
            r.add(candidate[i]);
            dfs(candidate, i+1, target-candidate[i], r, result);
            r.remove(r.size()-1);
        }
    }

}
