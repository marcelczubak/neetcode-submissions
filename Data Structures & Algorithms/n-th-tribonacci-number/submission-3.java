class Solution {
    public int tribonacci(int n) {
        
        Map<Integer, Integer> cache = new HashMap<>();

        return getTribonacci(cache, n);
    }

    private int getTribonacci(Map<Integer, Integer> cache, int n) {

        if (cache.containsKey(n)) return cache.get(n);
        
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int result = getTribonacci(cache, n-3) + getTribonacci(cache, n-2) + getTribonacci(cache, n-1);

        cache.put(n, result);

        return result;
    }
}