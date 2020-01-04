//package com.graph;
//import java.util.*;
//
//public class IslandPerimeter {
//    public int islandPerimeter(int[][] grid) {
//        //sanity check
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; i < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    return dfs(grid, visited, i, j); //only need one dfs
//                }
//            }
//        }
//    }
//
//    //MARK VISITED 1
//    //return value: the perimeter can be counted for the cur position
//    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
//        //base case
//        if (visited[r][c]) {
//            return 0;
//        }
//        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
//            return 1;
//        }
//        if (grid[r][c] == 0) {
//            return 1;
//        }
//        //mark visited
//        visited[r][c] = true;
//        //recursion
//        int count = 0;
//        count += dfs(grid, visited, r + 1);
//        count += dfs(grid, visited, r - 1);
//        count += dfs(grid, visited, r,c + 1);
//        count += dfs(grid, visited, r,c - 1);
//        //cur level return value
//        return count;
//    }
//}
//
