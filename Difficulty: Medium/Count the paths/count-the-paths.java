class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);

        Map<Integer, Integer> memo = new HashMap<>();

        return dfs(src, dest, graph, memo);
    }

    private int dfs(int node, int destination, List<List<Integer>> graph, Map<Integer, Integer> memo) {
        if (node == destination) return 1;
        if (memo.containsKey(node)) return memo.get(node);

        int totalPaths = 0;
        for (int neighbor : graph.get(node)) {
            totalPaths += dfs(neighbor, destination, graph, memo);
        }

        memo.put(node, totalPaths);
        return totalPaths;
        
    }
}