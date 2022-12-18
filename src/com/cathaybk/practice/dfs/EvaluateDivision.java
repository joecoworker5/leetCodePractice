package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> memo = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            double value = values[i];
            memo.computeIfAbsent(equations.get(i).get(0), l -> new HashMap()).computeIfAbsent(equations.get(i).get(1), l -> value);
            memo.computeIfAbsent(equations.get(i).get(1), l -> new HashMap()).computeIfAbsent(equations.get(i).get(0), l -> 1.0/value);
        }

        double[] result = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            if(!memo.containsKey(queries.get(i).get(0)) || !memo.containsKey(queries.get(i).get(1))){
                result[i]=-1;
            } else {
                 result[i]= dfs(queries.get(i).get(0),queries.get(i).get(1), memo, 1.0, new HashSet<String>());
            }
        }

        return result;
    }

    double dfs(String x, String y, Map<String, Map<String, Double>> memo, Double num, Set<String> set){
        if(x.equals(y)){
            return num;
        }
        Map<String, Double> map = memo.get(x);
        if(map == null){
            return -1;
        }
        Double result = null;
        set.add(x);
        for(String newX : map.keySet()){
            if(set.contains(newX)){
                continue;
            }
            Double val = map.get(newX);
            result = dfs(newX, y, memo, val * num, set);
           if(result > 0){
               return result;
           }
       }

        return -1;
    }
}
