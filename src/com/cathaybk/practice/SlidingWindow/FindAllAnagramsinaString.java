package com.cathaybk.practice.monotonicQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(pLen>sLen){
            return result;
        }

        int[] cntAry = new int[26];
        for(int i=0; i<pLen; i++){
            cntAry[p.charAt(i)-'a']++;
            cntAry[s.charAt(i)-'a']--;
        }

        if(allZero(cntAry)) result.add(0);

        for(int i=pLen; i<sLen; i++){
            cntAry[s.charAt(i)-'a']--;
            cntAry[s.charAt(i-pLen)-'a']++;
            if(allZero(cntAry)) result.add(i-pLen+1);
        }

        return result;
    }

    boolean allZero(int[] map){
        for(int cnt: map){
            if(cnt!=0) return false;
        }

        return true;
    }
}
