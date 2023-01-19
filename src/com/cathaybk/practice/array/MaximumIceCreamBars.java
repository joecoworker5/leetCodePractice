package com.cathaybk.practice.array;

import java.util.Arrays;

class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int costCoins = 0;
        int i=0;
        for(;i<costs.length; i++){
            costCoins += costs[i];
            if(costCoins > coins){
                return i;
            }
        }

        return costs.length;
    }

}
