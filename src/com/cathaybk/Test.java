package com.cathaybk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Test {

	public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int[] array = arrayList.toArray(new int[arrayList.size()]);
        ArrayList[] course = new ArrayList[Integer.valueOf(input)];
        for(int i=0; i<course.length; i++){
            course[i]=arrayList;
        }
        String  thisLine = null;
        while ((thisLine = br.readLine()) != null) {
            String[] s = thisLine.split(" ");
            course[Integer.valueOf(s[0])].add(Integer.valueOf(s[1]));
        }   
        int index = 0;
        int[] arra = new int[arrayList.size()];
        for(Integer i: arrayList){
        	arra[index++]=i;
        }
        System.out.println(canFinish(Integer.valueOf(input),course));
    }
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.add(i);
            
            if (i >= k - 1) {
                res[index++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }

    public static boolean canFinish(int numCourses,ArrayList[] course) {
        //1: visited, 2: finished
        int[] dfs = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!dfs(course, i,dfs )){
                return false;
            }
        }
        return true;
    }

    boolean dfs(ArrayList[] course, int courseNum, int[] dfs){
        if(dfs[courseNum]==2){
            return true;
        }
        if(dfs[courseNum]==1){
            return false;
        }
        dfs[courseNum]=1;
        ArrayList<Integer> precourse = course[courseNum];
        for(int i=0; i<precourse.size(); i++){
            if(!dfs(course,precourse.get(i),dfs)){
                return false;
            }
        }
        dfs[courseNum]=2;
        return true;
    }

}
