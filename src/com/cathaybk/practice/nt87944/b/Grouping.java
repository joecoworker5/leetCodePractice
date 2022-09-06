package com.cathaybk.practice.nt87944.b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grouping {

    public static void main(String[] args) throws IOException {
        String filename = "D:\\cars.csv";
        Grouping grouping = new Grouping();
        List<Map<String, String>> sortedList = grouping.collectionSort(filename);
        grouping.exportCSV(sortedList);
        List<Map<String, String>> manufacSort = grouping.manufacSort(sortedList);
        Map<String, String> header = manufacSort.remove(manufacSort.size() - 1);
        grouping.show(manufacSort, header);
    }

    public List<Map<String, String>> manufacSort(List<Map<String, String>> sortedList) throws IOException {

        Collections.sort(sortedList, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return o1.get("Manufacturer").compareTo(o2.get("Manufacturer"));
            }
        });
        return sortedList;
    }

    public List<Map<String, String>> collectionSort(String filename) throws IOException {

        List<Map<String, String>> list = new ArrayList<>();
        try (InputStreamReader isw = new InputStreamReader(new FileInputStream(filename), "UTF-8");
                BufferedReader br = new BufferedReader(isw);) {
            String str = null;
            while ((str = br.readLine()) != null) {
                Map<String, String> map = new HashMap<>();
                String[] arr1 = str.split(",");
                map.put("Manufacturer", arr1[0]);
                map.put("TYPE", arr1[1]);
                map.put("Min.PRICE", arr1[2]);
                map.put("Price", arr1[3]);
                list.add(map);
            }
            Map<String, String> header = list.remove(0);
            Collections.sort(list, new Comparator<Map<String, String>>() {
                @Override
                public int compare(Map<String, String> o1, Map<String, String> o2) {
                    return Double.valueOf(o2.get("Price")).compareTo(Double.valueOf(o1.get("Price")));
                }
            });
            list.add(0, header);
            return list;
        }
    }

    public void exportCSV(List<Map<String, String>> table) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        String destination = "d:\\cars2.csv";
        try (OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(destination), "UTF-8");) {
            StringBuilder str = new StringBuilder();
            for (Map<String, String> data : table) {
                str.append(data.get("Manufacturer") + "," + data.get("TYPE") + "," + data.get("Min.PRICE") + "," + data.get("Price"))
                        .append("\r\n");
                ow.write(str.toString());
                str.setLength(0);
            }
        }
    }

    public void show(List<Map<String, String>> manufacSort, Map<String, String> header) {
        BigDecimal minPriceSubtotal = BigDecimal.ZERO;
        BigDecimal priceSubtotal = BigDecimal.ZERO;
        BigDecimal minPriceTotal = BigDecimal.ZERO;
        BigDecimal priceTotal = BigDecimal.ZERO;
        String prev = null;
        
        Map<String, String> intiMap = manufacSort.get(0);
        minPriceSubtotal = minPriceSubtotal.add(new BigDecimal(intiMap.get("Min.PRICE")));
        priceSubtotal = priceSubtotal.add(new BigDecimal(intiMap.get("Price")));
        prev = intiMap.get("Manufacturer");
        
        for (int i = 1; i < manufacSort.size(); i++) {
            Map<String, String> m = manufacSort.get(i);
            if (priceSubtotal.equals(BigDecimal.ZERO) && minPriceSubtotal.equals(BigDecimal.ZERO) && !m.get("Manufacturer").equals("小計")) {
                minPriceSubtotal = minPriceSubtotal.add(new BigDecimal(m.get("Min.PRICE")));
                priceSubtotal = priceSubtotal.add(new BigDecimal(m.get("Price")));
            }

            if (m.get("Manufacturer").equals(prev)) {
                minPriceSubtotal = minPriceSubtotal.add(new BigDecimal(m.get("Min.PRICE")));
                priceSubtotal = priceSubtotal.add(new BigDecimal(m.get("Price")));
                if (i + 1 < manufacSort.size()) {
                    if (!m.get("Manufacturer").equals(manufacSort.get(i + 1).get("Manufacturer"))) {
                        if (!m.get("Manufacturer").equals("小計") || !manufacSort.get(i + 1).get("Manufacturer").equals("小計")) {
                            calculateSubTotalAndTotal(i,minPriceTotal, priceTotal, minPriceSubtotal,  priceSubtotal, manufacSort); 
                            minPriceSubtotal = BigDecimal.ZERO;
                            priceSubtotal = BigDecimal.ZERO;
                        }
                    }

                } else {
                    calculateSubTotalAndTotal(i,minPriceTotal, priceTotal, minPriceSubtotal,  priceSubtotal, manufacSort); 
                    minPriceSubtotal = BigDecimal.ZERO;
                    priceSubtotal = BigDecimal.ZERO;
                }
            } else if (prev.equals("小計") && !manufacSort.get(i + 1).get("Manufacturer").equals(m.get("Manufacturer"))) {
                calculateSubTotalAndTotal(i,minPriceTotal, priceTotal, minPriceSubtotal,  priceSubtotal, manufacSort);
                minPriceSubtotal = BigDecimal.ZERO;
                priceSubtotal = BigDecimal.ZERO;
            }
            prev = m.get("Manufacturer");
        }
        Map<String, String> map = new HashMap<>();
        map.put("Manufacturer", "合計");
        map.put("Min.PRICE", minPriceTotal.toString());
        map.put("Price", priceTotal.toString());
        manufacSort.add(map);
        System.out.println("Manufacturer TYPE  Min.PRICE  Price");
        for (Map<String, String> row : manufacSort) {
            String type;
            if (row.get("TYPE") == null) {
                type = "                                  ";
            } else {
                type = row.get("TYPE");
            }
            System.out.printf("%-10s", row.get("Manufacturer"));
            System.out.printf("%-10s", type);
            System.out.printf("%-10s", row.get("Min.PRICE"));
            System.out.printf("%-10s", row.get("Price"));
            System.out.println();
        }
    }
    
    private void calculateSubTotalAndTotal (int index, BigDecimal minPriceTotal, BigDecimal priceTotal, BigDecimal minPriceSubtotal, BigDecimal priceSubtotal, List<Map<String, String>> manufacSort){
        Map<String, String> map = new HashMap<>();
        minPriceTotal = minPriceTotal.add(minPriceSubtotal);
        priceTotal = priceTotal.add(priceSubtotal);  
        map.put("Manufacturer", "小計");
        map.put("Min.PRICE", minPriceSubtotal.toString());
        map.put("Price", priceSubtotal.toString());
        manufacSort.add(index + 1, map);

    }
}
