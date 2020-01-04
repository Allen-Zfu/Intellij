//package com.Model;
//import java.util.*
//
//public class DFSMarkVisitedTwo {
//    enum State {
//        UNVISITED,
//        VISITED,
//        VISITING;
//    }
//
//    class Vertex {
//        State state = State.UNVISITED;
//        List<Vertex> neighbors;
//    }
//
//    public void dfs(Vertex v) {
//        //base case
//        if (v.state = State.VISITED) {
//            return;
//        }
//        if (v.state = State.VISITING) {
//            return;
//        }
//        //same path mark visited
//        v.state = State.VISITING;
//        for (Vertex n : v.neighbors) {
//            dfs(n);
//        }
//        v.state= State.VISITED;
//    }
//}
