package com.cathaybk.practice.dp;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = { -2, 0 };
		int result = new MaximumProductSubarray().maxProduct(nums);
		System.out.println(result);
	}

	public int maxProduct(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int maxProduct = 0;
		int firstMinusProd = 1;
		int lastMinusIndex = nums.length;
		int lastMinusProd = 1;
		int product = 1;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				if (product > 0) {
					maxProduct = Math.max(maxProduct, product);
				} else {
					if (!(product == lastMinusProd && product == firstMinusProd))
						maxProduct = Math.max(maxProduct, Math.max(product / lastMinusProd, product / firstMinusProd));
				}
				product = i != nums.length - 1 ? 1 : product;
				firstMinusProd = 1;
				lastMinusIndex = nums.length;
				lastMinusProd = 1;
				continue;
			}
			product *= nums[i];
			if (nums[i] < 0) {
				firstMinusProd = firstMinusProd == 1 ? product : firstMinusProd;
				lastMinusIndex = i;
				lastMinusProd = 1;
			}
			if (i >= lastMinusIndex) {
				lastMinusProd *= nums[i];
			}

		}
		if (product > 0) {
			maxProduct = Math.max(maxProduct, product);
		} else {
			if (!(product == lastMinusProd && product == firstMinusProd))
				maxProduct = Math.max(maxProduct, Math.max(product / lastMinusProd, product / firstMinusProd));
		}

		return maxProduct;
	}
}
