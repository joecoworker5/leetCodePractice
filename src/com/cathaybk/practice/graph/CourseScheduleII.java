package com.cathaybk.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

	public static void main(String[] args) {

	}
	//bfs
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] incomingEdges = new int[numCourses];
		List<Integer>[] goCourses = new List[numCourses];
		for (int i = 0; i < goCourses.length; i++) {
			goCourses[i] = new LinkedList<Integer>();
		}
		for (int[] pair : prerequisites) {
			incomingEdges[pair[0]]++;
			goCourses[pair[1]].add(pair[0]);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < incomingEdges.length; i++) {
			if (incomingEdges[i] == 0) {
				queue.add(i);
			}
		}
		int edgeCnt = prerequisites.length;
		int[] result = new int[numCourses];
		List<Integer> resultList = new ArrayList<>();
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			resultList.add(cur);
			for (int goCrs : goCourses[cur]) {
				edgeCnt--;
				if (--incomingEdges[goCrs] == 0)
					queue.add(goCrs);
			}
		}

		if (edgeCnt == 0) {
			for (int i = 0; i < resultList.size(); i++) {
				result[i] = resultList.get(i);
			}
			return result;
		} else {
			return new int[0];
		}

	}
	
	//dfs
	public int[] findOrder1(int numCourses, int[][] prerequisites) {
		ArrayList[] course = new ArrayList[numCourses];
        for(int i=0; i<course.length; i++){
            course[i]=new ArrayList<Integer>();
        }
        for(int[] prerequisite: prerequisites){
            course[prerequisite[0]].add(prerequisite[1]);
        }
        //1: visited, 2: finished
        int[] dfs = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(!dfs(course, i,dfs, list )){
                return new int[0];
            }
        }
        return list.stream().mapToInt(i->i).toArray();
	}
    
    boolean dfs(ArrayList[] course, int courseNum, int[] dfs,  List<Integer> list){
        if(dfs[courseNum]==2){
            return true;
        }
        if(dfs[courseNum]==1){
            return false;
        }
        dfs[courseNum]=1;
        ArrayList<Integer> precourse = course[courseNum];
        for(int i=0; i<precourse.size(); i++){
            if(!dfs(course,precourse.get(i),dfs, list)){
                return false;
            }
        }
        dfs[courseNum]=2;
        list.add(courseNum);
        return true;
    }
}
