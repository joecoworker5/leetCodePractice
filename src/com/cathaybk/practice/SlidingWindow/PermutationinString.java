package com.cathaybk.practice.SlidingWindow;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class PermutationinString {

	// 用 int[26] 來裝字母的count,比 map 還省空間
	public boolean checkInclusionSlidingWindow(String s1, String s2) {
        int[] map = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        for(int i=0; i< len1; i++){
            map[s1.charAt(i)-'a']++;
            map[s2.charAt(i)-'a']--;
        }

        if(allZero(map)) return true;
        for(int i=len1; i<len2; i++){
            map[s2.charAt(i)-'a']--;
            map[s2.charAt(i-len1)-'a']++;
            if(allZero(map)) return true;
        }
        return false;
    }

    boolean allZero(int[] map){
        for(int cnt: map){
            if(cnt!=0) return false;
        }

        return true;
    }


	// 沒那麼簡潔
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        Queue<Character> q = new LinkedList<>();
        char[] strs = s2.toCharArray();
        for(int index = 0; index< strs.length; index++){
            q.add(strs[index]);
            while(q.size()>window){
                q.poll();
            }
            if(q.size()==window){
                if(dfs(q, s1)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(Queue<Character> q, String s1){
        int[] altha = new int[26];
        for(int i=0 ; i< s1.length(); i++){
            altha[s1.charAt(i)-'a']++;
        }
        for(char s: q){
            altha[s-'a']--;
        }

        for(int cnt : altha){
            if(cnt!=0){
                return false;
            }
        }

        return true;
    }
}
