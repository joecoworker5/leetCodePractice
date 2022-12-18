package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] courses = new ArrayList[numCourses];
        for(int i=0; i<courses.length; i++){
            courses[i] = new ArrayList();
        }

        for(int[] pre : prerequisites){
            courses[pre[0]].add(pre[1]);
        }
        int[] status = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(status[i]==0){
                if(!dfs(i, courses, status)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(Integer index, List[] courses, int[] status){
        if(status[index]==1){
            return false;
        }

        if(status[index]==2){
            return true;
        }

        status[index]=1;
        List<Integer> course = courses[index];
        for(Integer i: course){
            if(!dfs(i, courses, status)){
                return false;
            }
        }
        status[index]=2;
        return true;

    }
}
