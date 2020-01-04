//package com.graph;
//import java.util.*;
//import com.HelperFunction.GraphNode;
//
//public class copyGraphList {
//    public class Solution {
//        public List<GraphNode> copy(List<GraphNode> graph) {
//            List<GraphNode> copyGraph = new LinkedList<>();
//            Map<GraphNode, GraphNode> visited = new HashMap<>();
//            for (GraphNode v : graph) {
//                //copy 'unvisited' vertex v
//                visited.putIfAbsent(v, new GraphNode(v));
//                //copy all 'unvisited' neighbor of v
//                for (GraphNode n : v.neighbors) {
//                    visited.putIfAbsent(n, new GraphNode(n));
//                    //copy all edges from cur vertex v
//                    visited.get(v).neighbors.add(visited.get(n));
//                }
//                copyGraph.add(v);
//            }
//            return copyGraph;
//        }
//    }
//}
