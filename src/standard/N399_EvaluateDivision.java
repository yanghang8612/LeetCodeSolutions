package standard;

import java.util.*;

public class N399_EvaluateDivision {

    private Map<String, Map<String, Double>> graph = new HashMap<>();
    private Set<String> visited = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        for (int i = 0; i < n; i++) {
           String u = equations.get(i).get(0);
           String v = equations.get(i).get(1);
           graph.putIfAbsent(u, new HashMap<>());
           graph.get(u).put(v, values[i]);
           graph.putIfAbsent(v, new HashMap<>());
           graph.get(v).put(u, 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1));
            visited.clear();
        }
        return res;
    }

    private double dfs(String start, String end) {
        if (graph.containsKey(start)) {
            if (graph.get(start).containsKey(end)) return graph.get(start).get(end);
            visited.add(start);
            for (Map.Entry<String, Double> e : graph.get(start).entrySet()) {
                if (!visited.contains(e.getKey())) {
                    double res = dfs(e.getKey(), end);
                    if (res != -1.0) return e.getValue() * res;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {

    }
}
