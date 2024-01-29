package com.cathaybk.practice.dfs;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        dfs(word1, word2, 0, 0, sb);
        return sb.toString();
    }

    void dfs(String word1, String word2, int index1, int index2, StringBuilder sb){
        if(index1 >= word1.length() && index2 >= word2.length()){
            return;
        }

        if(index1 >= word1.length()){
            String rest = word2.substring(index2);
            sb.append(rest);
            return;
        } else if ( index2 >= word2.length()){
            String rest = word1.substring(index1);
            sb.append(rest);
            return;
        }

        if(index1>index2){
            String one = word2.substring(index2, index2+1);
            sb.append(one);
            dfs(word1, word2, index1, index2+1, sb);
        } else {
            String one = word1.substring(index1, index1 + 1);
            sb.append(one);
            dfs(word1, word2, index1 + 1, index2, sb);
        }
    }
}
