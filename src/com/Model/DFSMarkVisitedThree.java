//package com.Model;
//import java.util.*
//
//public class DFSMarkVisitedThree {
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
//    public void dfs(Vertex v) {
//        //base case
//        if (v.state == State.VISITED) {
//            return;
//        }
//        //mark visited at expand
//        v.state = State.VISITED;
//        for (Vertex n : v.neighbors) {
//            dfs(n);
//        }
//        //recovery
//        v.state = State.UNVISITED;
//    }
//}
