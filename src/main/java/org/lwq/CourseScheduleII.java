package org.lwq;

import org.assertj.core.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution : BFS
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // count courses' prerequisites
        int[] pc = new int[numCourses];
        for(int[] p: prerequisites){
            pc[p[0]]++;
        }

        // add no prerequisite course to the final order
        List<Integer> order = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(pc[i] == 0){
                order.add(i);
            }
        }

        // Initialize a queue of no prerequisite course
        LinkedList<Integer> queue = new LinkedList<>(order);

        // BFS search for the final order
        while(!queue.isEmpty()){
            int npCourse = queue.removeFirst();
            for(int[] p: prerequisites){
                if(p[1] == npCourse){
                    int pCourse = p[0];
                    pc[pCourse]--;
                    if(pc[pCourse] == 0){
                        queue.add(pCourse);
                        order.add(pCourse);
                    }
                }
            }
        }

        if(order.size() == numCourses){
            return order.stream().mapToInt(i->i).toArray();
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        Assertions.assertThat(solution.findOrder(2, new int[][]{{1, 0}})).containsExactly(0, 1);
        Assertions.assertThat(solution.findOrder(4, new int[][]{{1,0}, {2, 0}, {3,1}, {3,2}})).containsExactly(0,1,2,3);
        Assertions.assertThat(solution.findOrder(1, new int[][]{})).containsExactly(0);
    }
}
