class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        // Create adjacency list (graph)
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            Set<Integer> visited = new HashSet<>();

            if (dfs(adjacencyList, visited, u, v)) {
                return edge;
            } else {
                adjacencyList.putIfAbsent(u, new HashSet<>());
                adjacencyList.putIfAbsent(v, new HashSet<>());
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
        }   
        return new int[]{-1,-1};
    }


    // Returns true if path exists from u to v
    private boolean dfs(Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visited, int u, int v) {
        
        if (u == v) return true;
        if (visited.contains(u)) return false;

        visited.add(u);

        Set<Integer> neighbors = adjacencyList.getOrDefault(u, new HashSet<>());
        for (int neighbor : neighbors) {
            if (dfs(adjacencyList, visited, neighbor, v)) return true;
        }
        return false;
    }


}
