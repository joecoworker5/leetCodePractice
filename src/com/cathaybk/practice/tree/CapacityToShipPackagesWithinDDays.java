package com.cathaybk.practice.tree;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights,
                              int days) {
        int leastCapacity = 0;
        int maxCapacity = 0;
        for (int w : weights) {
            leastCapacity = Math.max(leastCapacity, w);
            maxCapacity += w;
        }

        while (leastCapacity < maxCapacity) {
            int mid = (leastCapacity + maxCapacity) / 2;
            int day = 1, cargoWeightSoFar = 0;
            for (int w : weights) {
                if (cargoWeightSoFar + w > mid) {
                    day += 1;
                    cargoWeightSoFar = 0;
                }
                cargoWeightSoFar += w;
            }
            if (day > days) {
                leastCapacity = mid + 1;
            }
            else {
                maxCapacity = mid;
            }
        }

        return leastCapacity;
    }
}
