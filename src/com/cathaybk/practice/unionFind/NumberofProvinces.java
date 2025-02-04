package com.cathaybk.practice.unionFind;

class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    public class UnionFind {
        public int count = 0;

        private int[] cities;

        public UnionFind() {
        }

        public UnionFind(int[][] isConnected) {
            int m = isConnected.length;
            cities = new int[m];
            for (int i = 0; i < m; i++) {
                cities[i] = i;
                count++;
            }
        }

        public void union(int index1,
                int index2) {
            int parent1 = find(index1);
            int parent2 = find(index2);
            if (parent1 != parent2) {
                count--;
                cities[parent1] = parent2;
            }
        }

        public int find(int descendent) {
            int temp = descendent;
            while (cities[temp] != temp) {
                temp = cities[temp];
            }

            return temp;
        }
    }
}