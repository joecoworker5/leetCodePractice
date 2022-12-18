package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, result);
        return result;
    }

    void dfs(int[] nums, boolean[] visited, List<Integer> tracking, List<List<Integer>> result){
        if(nums.length == tracking.size()){
            result.add(new ArrayList<>(tracking));
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            tracking.add(nums[i]);
            visited[i]=true;
            dfs(nums, visited, tracking, result);
            visited[i]=false;
            tracking.remove(tracking.size()-1);
        }
    }
}
