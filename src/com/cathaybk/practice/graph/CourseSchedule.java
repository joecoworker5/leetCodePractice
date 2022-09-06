package com.cathaybk.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {

	}
	//DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] canFinish = new boolean[numCourses]; // history
		boolean[] visited = new boolean[numCourses];
		List<Integer>[] courses = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			courses[prerequisites[i][0]].add(prerequisites[i][1]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(courses, courses[i], i, visited, canFinish)) {
				return false;
			}
		}

		return true;
	}

	boolean dfs(List<Integer>[] courses, List<Integer> prerequisites, int i, boolean[] visited, boolean[] canFinish) {
		if (canFinish[i])
			return true;
		if (visited[i])
			return false;

		visited[i] = true;
		for (Integer whichCourse : prerequisites) {
			if (!dfs(courses, courses[whichCourse], whichCourse, visited, canFinish)) {
				return false;
			}
		}
		visited[i] = false;
		canFinish[i] = true;
		return true;
	}
	
	//BFS topological sort
	public boolean canFinish1(int numCourses, int[][] prerequisites){
	    int[] incomingEdges = new int[numCourses];
	    List<Integer>[] goCourses = new List[numCourses];
	    for(int i=0;i<goCourses.length;i++){
	        goCourses[i] = new LinkedList<Integer>();
	    }
	    for(int[] pair: prerequisites){
	        incomingEdges[pair[0]]++;
	        goCourses[pair[1]].add(pair[0]);
	    }
	    Queue<Integer> queue = new LinkedList<Integer>();
	    for(int i=0;i<incomingEdges.length;i++){
	        if(incomingEdges[i]==0){
	            queue.add(i);
	        }
	    }
	    int edgeCnt = prerequisites.length;
	    while(!queue.isEmpty()){
	        int cur = queue.poll();
	        for(int goCrs: goCourses[cur]){
	             edgeCnt--;
	             if(--incomingEdges[goCrs]==0)
	                queue.add(goCrs);
	        }
	    }
	    return edgeCnt==0;
	}
	
	

}
