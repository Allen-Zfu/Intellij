//package com.Model;
//import java.util.*;
//
//
///*
//DFS mark visited 1:
//    性质：travers vertex
//
//    TC: O(V + E)
//    SC: O(recursion height), worst O(V)
//
//    Mark Visited：
//        at expand
//*/
//
//public class dfs {
//    enum State {
//        UNVISITED,
//        VISITED;
//    }
//
//    class Vertex {
//        State state = State.UNVISITED;
//        List<Vertex> neighbors;
//    }
//
//    public void dfsMarkVisitedOne(Vertex v) {
//        //base case
//        if (v.state == State.VISITED) {
//            return;
//        }
//        //mark visited
//        v.state = State.VISITED;
//        for (Vertex n : v.neighbors) {
//            dfs(n);
//        }
//    }
//}
//
//
//
//
//
