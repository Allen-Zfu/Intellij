package com.graph;
import java.util.*;

public class Bipartitie {
    public boolean isBipartite(int[][] graph) {
        //sanity check...
        HashMap<Integer, Integer> colorFill = new HashMap<>();  //vertex color info(mark visited)
        //unconnected graph
        for (int i = 0; i < graph.length; i++) {   //遍历所有vertex，开始一次BFS
            if (!colorFill.containsKey(i)) {       //只有没有遍历过额connected area才需要做dFS
                if (!dfs(graph, i, 0,colorFill, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    //index: 目前走到开始dfs的vertex的第几层vertex
    //关键：连接前后两层两个node的染色信息并且做出判断
    //所带入的row信息告知目前从哪个vertex开始的dfs
    //index信息表示当前dfs进行到了哪一层（#col即为#nei of cur）
    private boolean dfs(int[][] graph, int row, int index, HashMap<Integer, Integer> colorFill, int prevColor) {
        //base case
        if (index == graph[row].length) {    //一直能够走到底，说明这个connnected area是bipartite
            return true;
        }
        Integer cur = graph[row][index];
        Integer curColor = prevColor == 0 ? 1 : 0;
        if (!colorFill.containsKey(cur)) {
            colorFill.put(cur, curColor);
        } else if (colorFill.get(cur) != curColor) {
            return false;
        }

        //recursion (还是同一个vertex开始的dfs，所以row不变，col往后走一位（即index+1)
        dfs(graph, row, index +1, colorFill, curColor);
        return true;
    }
}




