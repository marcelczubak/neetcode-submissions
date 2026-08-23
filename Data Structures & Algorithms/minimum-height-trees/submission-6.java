class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // Brute force O(N^2)

        // Construct an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        int minHeight = Integer.MAX_VALUE;

        // {node -> height}
        Map<Integer, Integer> heights = new HashMap<>();

        // Iterate through all nodes
        for (int i = 0; i < n; i++) {
            
            int height = dfs(graph, -1, i);

            if (height <= minHeight) {
                minHeight = height;
                heights.put(i, height);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (heights.get(node) != null && heights.get(node) == minHeight) {
                result.add(node);
            }
        }

        return result;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int parent, int node) {

        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());

        int maxHeight = 0;

        for (Integer neighbor : neighbors) {
            if (neighbor == parent) continue;
            maxHeight = Math.max(maxHeight, dfs(graph, node, neighbor));
        }

        return 1 + maxHeight;
    }
}