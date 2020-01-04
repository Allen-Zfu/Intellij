package com.graph;
import java.util.*;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,3,4,5,7,8,6,9,2};
        JumpGameII ob = new JumpGameII();
        System.out.println(ob.jump(nums));
    }

    //BFS mark visited at generation
    public int jump(int[] nums) {
        //sanity check
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        //build graph (directed)
        List<List<Integer>> graph = buildGraph(nums);
        //run find shortest diatance bfs on graph
        return bfs(0, nums.length - 1, graph);
    }


    private int bfs(int init, int goal, List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        //init
        queue.offer(init);
        //mark visited init
        visited.add(init);
        //prepare for calculate shortest distance
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (Integer nei : graph.get(cur)) {
                    if (nei == goal) {
                        return level + 1;
                    }
                    if (visited.add(nei)) {
                        queue.offer(nei);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<List<Integer>> buildGraph(int[] nums) {
        List<List<Integer>> graph = new ArrayList<>();
        //build vertex
        for (int i = 0; i < nums.length; i++) {
            graph.add(i, new ArrayList<>());
        }
        //build edges
        for (int i = 0; i < nums.length; i++) {
            int u = i;
            for (int v = i; v <= Math.min(nums.length - 1, i + nums[i]); v++) {
                graph.get(u).add(v);
            }
        }
        return graph;
    }
}
