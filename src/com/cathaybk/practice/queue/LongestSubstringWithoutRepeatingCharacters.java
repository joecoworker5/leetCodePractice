package com.cathaybk.practice.queue;


import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        q.add(s.charAt(0));
        int maxSize = 0;
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            if(q.contains(c)){
                maxSize = Math.max(maxSize, q.size());
                while(q.contains(c)){
                    q.poll();
                }
            }
            q.add(c);
        }

        return Math.max(maxSize, q.size());
    }
}
