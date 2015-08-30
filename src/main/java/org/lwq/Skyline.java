package org.lwq;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * Solution : Use Heap to
 */
public class Skyline {

    class Edge{
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {

        if(buildings.length == 0){
            return new ArrayList<>();
        }

        // collect edges and mark ending edge with negative height
        List<Edge> edges = new ArrayList<>();
        for(int[] building: buildings){
            edges.add(new Edge(building[0], building[2]));
            edges.add(new Edge(building[1], -building[2]));
        }

        // sort edges by position in ascending and height in descending
        edges.sort((e1, e2) -> {
            if (e1.x != e2.x) {
                return e1.x - e2.x;
            } else {
                return e2.y - e1.y;
            }
        });

        List<int[]> results = new ArrayList<>();
        // heap ordered by height in descending
        Queue<Integer> heap = new PriorityQueue<>((x1,x2)->x2-x1);

        for(Edge edge: edges){

            if(edge.y > 0){
                if(heap.isEmpty() || edge.y > heap.peek()){
                    results.add(new int[]{edge.x, edge.y});
                }
                heap.add(edge.y);
            } else {
                int height = -edge.y;
                heap.remove(height);

                if(heap.isEmpty()){
                    results.add(new int[]{edge.x, 0});
                } else if(height > heap.peek()){
                    results.add(new int[]{edge.x, heap.peek()});
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Skyline solution = new Skyline();

        int[][] buildings = new int[][]{
            {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
        };

        Assertions.assertThat(solution.getSkyline(buildings)).containsExactly(
            new int[]{2, 10}, new int[]{3, 15}, new int[]{7, 12}, new int[]{12, 0},
            new int[]{15, 10}, new int[]{20, 8}, new int[]{24, 0}
        );

        buildings = new int[][]{
            {1,2,1}, {1,2,2}, {1,2,3}
        };

        Assertions.assertThat(solution.getSkyline(buildings)).containsExactly(
            new int[]{1, 3}, new int[]{2, 0}
        );

        buildings = new int[][]{
            {3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}
        };
        Assertions.assertThat(solution.getSkyline(buildings)).containsExactly(
            new int[]{3, 8}, new int[]{7, 7}, new int[]{8, 6}, new int[]{9, 5},
            new int[]{10, 4}, new int[]{11, 3}, new int[]{12,2}, new int[]{13, 1}, new int[]{14, 0}
        );

    }
}
