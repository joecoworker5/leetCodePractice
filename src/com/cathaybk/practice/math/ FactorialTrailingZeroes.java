package com.cathaybk.practice.math;


class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ans = 0;
        for(int i=5; i<=n; i=i*5){
            int count = n/i;
            ans+=count;
        }

        return ans;
    }
}
