package com.cathaybk.practice.dfs;

import java.util.ArrayList;
import java.util.List;

class CourseScheduleII {

    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {
        List<Integer>[] courses = new ArrayList[numCourses];
        int[] status = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            courses[pre[0]].add(pre[1]);
        }

        for (int i = 0; i < courses.length; i++) {
            if (!dfs(i, courses, status, result)) {
                return new int[0];
            }
        }
        int[] r = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            r[i]=result.get(i);
        }
        return r;
    }

    boolean dfs(int i,
                List<Integer>[] courses,
                int[] status,
                List<Integer> result) {
        if (status[i] == 1) {
            return false;
        }
        if (status[i] == 2) {
            return true;
        }
        status[i] = 1;
        List<Integer> course = courses[i];
        for (Integer c : course) {
            if (!dfs(c, courses, status, result)) {
                return false;
            }
        }
        result.add(i);
        status[i] = 2;
        return true;
    }
}
