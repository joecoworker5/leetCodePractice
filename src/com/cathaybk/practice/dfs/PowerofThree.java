package com.cathaybk.practice.dfs;

import com.cathaybk.practice.tree.TreeNode;

public class PowerofThree {

    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        return dfs(n);
    }

    boolean dfs(int n){
        if(n==1){
            return true;
        }
        if(n%3!=0){
            return false;
        }

        return dfs(n/3);
    }
}
