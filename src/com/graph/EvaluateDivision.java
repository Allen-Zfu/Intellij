package com.graph;
import java.util.*;
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //step 1: put the input into hashmp （building the map）
        Map<String, Map<String,Double>> edges = new HashMap<>();
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            //m--dividend   n-- divisor  q--quotient
            String m = equations.get(i).get(0);
            String n = equations.get(i).get(1);
            double q = values[i];
            edges.putIfAbsent(m, new HashMap<>());
            edges.get(m).put(n, values[i]);
            edges.putIfAbsent(n, new HashMap<>());
            edges.get(n).putIfAbsent(m, 1 / values[i]);

//             if (!edges.containsKey(m)) {
//                 edges.put(m, new HashMap<>());
//             }
//             edges.get(m).put(n, q);

            //     if (!edges.containsKey(n)) {
            //         edges.put(n, new HashMap<>());
            //     }
            //     edges.get(n).put(m, 1/q);
            // }

            //step 3: get result according to dfs judgement
            Set<String> visited = new HashSet<>();
            for (int j = 0; j < queries.size(); j++) {
                String mq = queries.get(j).get(0);
                String nq = queries.get(j).get(1);
                if (!edges.containsKey(mq) || !edges.containsKey(nq)) {
                    res[j] = -1.0;
                } else {
                    res[j] = DFS(edges, mq, nq, visited);
                }
            }
        }
        return res;
    }

    private double DFS(Map<String, Map<String, Double>> edges, String m, String n, Set<String> visited) {
        if (m.equals(n)) {
            return 1.0;
        }
        visited.add(m);
        if (!edges.containsKey(m)) {
            return -1.0;
        }
        for (String node : edges.get(m).keySet()) {
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            double d = DFS(edges,node, n, visited);
            if (d > 0) {
                return d * edges.get(m).get(node);
            }
        }
        return -1.0;
    }
}