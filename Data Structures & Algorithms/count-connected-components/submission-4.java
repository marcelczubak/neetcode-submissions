class Solution {
    public int countComponents(int n, int[][] edges) {

        // Build adjacency list
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.putIfAbsent(edge[0], new HashSet<>());
            adjacencyList.putIfAbsent(edge[1], new HashSet<>());
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        int components = 0;

        Set<Integer> visited = new HashSet<>();

        for (int node : adjacencyList.keySet()) {

            if (!visited.contains(node)) {
                dfs(adjacencyList, visited, node);
                components++;
            }


        }
        return (visited.size() == n) ? components : components + (n - visited.size());
    }

    private void dfs(Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visited, int node) {

        if (visited.contains(node)) return;

        visited.add(node);

        Set<Integer> neighbors = adjacencyList.getOrDefault(node, new HashSet<>());

        for (int neighbor : neighbors) {
            dfs(adjacencyList, visited, neighbor);
        }


    }


}
