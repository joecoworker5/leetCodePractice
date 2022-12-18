package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, 1, 0, n, "(");
        return result;
    }

    void dfs(List<String> result,
             Integer left,
             Integer right,
             Integer target,
             String combination) {
        if (right > left || left > target) {
            return;
        }

        if (left.equals(target) && right.equals(target)) {
            result.add(combination);
            return;
        }

        dfs(result, left + 1, right, target, combination + "(");
        dfs(result, left, right + 1, target, combination + ")");
    }
}
