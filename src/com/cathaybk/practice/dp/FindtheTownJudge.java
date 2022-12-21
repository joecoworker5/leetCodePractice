package com.cathaybk.practice.dp;

class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n + 1];
        for(int[] t: trust){
            people[t[1]]++;
            people[t[0]]--;
        }

        for(int i=1; i<n+1; i++){
            if(people[i]==n-1) return i;
        }

        return -1;
    }
}