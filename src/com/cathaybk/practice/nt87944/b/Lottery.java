package com.cathaybk.practice.nt87944.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottery {
    static StringBuilder lotStr = new StringBuilder();

    static StringBuilder lotSortStr = new StringBuilder();

    public static void main(String[] args) {
        Set<Integer> judge = new HashSet<>();
        List<Integer> lotnums = new ArrayList<>();
        lotStr.append("排序前  :");
        lotSortStr.append("排序後  :");
        while (lotnums.size() < 6) {
            int random = (int) (Math.random() * 49) + 1;
            if (judge.add(random)) {
                lotnums.add(random);
            }
        }
        Lottery.print1(lotnums);
        Lottery.sort(lotnums);
        Lottery.print2(lotnums);

    }

    static List<Integer> sort(List<Integer> input) {
        int length = input.size();
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }
        return input;
    }

    static void print1(List<Integer> lot) {
        for (Integer num : lot) {
            lotStr.append(num.toString() + " ");
        }
        System.out.println(lotStr);
    }

    static void print2(List<Integer> lot) {
        for (Integer num : lot) {
            lotSortStr.append(num.toString() + " ");
        }
        System.out.println(lotSortStr);
    }
}
