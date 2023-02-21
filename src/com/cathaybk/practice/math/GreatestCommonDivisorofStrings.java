package com.cathaybk.practice.math;


class GreatestCommonDivisorofStrings {
    // 輾轉相除法
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";

        int index = gcd(str1.length(), str2.length());
        return str1.substring(0, index);
    }

    int gcd(int p, int q){
        if(q==0) return p;
        return gcd(q,p%q);
    }
}
