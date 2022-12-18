package com.cathaybk.practice.dp;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int[] prices = {7,1,5,49,0,50};
		int maxProfit = new BestTimetoBuyandSellStock().maxProfit(prices);
		System.out.println(maxProfit);
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int max = 0;
		int maxIndex = 0;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				minIndex = i;
			}
			if (maxIndex <= minIndex || prices[i] > max) {
				max = prices[i];
				maxIndex = i;
			}

			if (maxIndex > minIndex) {
				maxProfit = Math.max(max - min, maxProfit);
			}

		}

		return maxProfit;
	}

	public int maxProfitSimpler(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int max = 0;
        int soFarMin = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]<soFarMin){
                soFarMin = prices[i];
            } else {
                max = Math.max(max, prices[i]-soFarMin);
            }
        }

        return max;
    }

}
