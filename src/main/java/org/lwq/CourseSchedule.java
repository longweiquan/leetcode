package org.lwq;

import org.assertj.core.api.Assertions;

import java.util.LinkedList;

/**
 * Problem : Topological Sort
 * Analyse : Find out the no cycle courses, then reduce other no cycle courses, then count the no cycle courses.
 * Solution : use BFS to find out
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // count courses' prerequisites
        int[] pc = new int[numCourses];
        for(int[] p: prerequisites){
            pc[p[0]]++;
        }

        // Init a queue of no prerequisite courses
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(pc[i] == 0){
                queue.add(i);
            }
        }
        int result = queue.size();

        // BFS
        while(!queue.isEmpty()){

            int npCourse = queue.removeFirst();
            for(int[] p: prerequisites){
                if(p[1] == npCourse){
                    int pCourse = p[0];
                    pc[pCourse] --;
                    if(pc[pCourse] == 0){
                        queue.add(pCourse);
                        result++;
                    }
                }
            }
        }

        return result == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        Assertions.assertThat(solution.canFinish(2, new int[][]{{1,0}})).isEqualTo(true);
        Assertions.assertThat(solution.canFinish(2, new int[][]{{1,0}, {0,1}})).isEqualTo(false);
        Assertions.assertThat(solution.canFinish(3, new int[][]{{1,0}, {0,2}, {2,1}})).isEqualTo(false);
    }
}
