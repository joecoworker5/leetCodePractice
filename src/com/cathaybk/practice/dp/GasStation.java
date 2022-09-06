package com.cathaybk.practice.dp;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 3 };
		int[] cost = { 3 };
		int result = new GasStation().canCompleteCircuit(gas, cost);
		System.out.println(result);
	}

	// time out of limited
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			if (gas[i] >= cost[i]) {
				int result = greedy(gas, cost, i);
				if (result != -1) {
					return result;
				}
			}
		}

		return -1;
	}

	int greedy(int[] gas, int[] cost, int index) {
		int totalGas = 0;
		int totalCost = 0;
		for (int i = index; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			if (totalGas < totalCost) {
				return -1;
			}
		}

		for (int i = 0; i < index; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			if (totalGas < totalCost) {
				return -1;
			}
		}

		return index;
	}

	// greedy solution
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += (gas[i] - cost[i]);
		}

		if (total < 0) {
			return -1;
		}

		int tank = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += (gas[i] - cost[i]);
			if (tank < 0) {
				index = i + 1;
				tank = 0;
			}

		}
		return index;
	}
}
