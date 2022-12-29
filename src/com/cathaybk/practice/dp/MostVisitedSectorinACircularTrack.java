package com.cathaybk.practice.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostVisitedSectorinACircularTrack {

	public List<Integer> mostVisited(int n, int[] rounds) {
        if(rounds.length==1){
            return Collections.singletonList(rounds[1]);
        }
        int[] num = new int[n + 1];
        int max = 1;
        int temp = rounds[0];
        num[temp]++;
        for(int i=1; i<rounds.length; i++){
            int round = rounds[i];
            if(round == temp){
                continue;
            } else if(round >temp){
                while(round>temp){
                    max = Math.max(++num[round], max);
                    round--;
                }
            } else {
                int size = n;
                while(temp<size){
                    max = Math.max(++num[++temp], max);
                }

                while(round>0){
                    max = Math.max(++num[round], max);
                    round--;
                }
            }

            temp = rounds[i];
        }
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<n+1; i++){
            if(num[i]==max){
                result.add(i);
            }
        }

        return result;
    }

}
