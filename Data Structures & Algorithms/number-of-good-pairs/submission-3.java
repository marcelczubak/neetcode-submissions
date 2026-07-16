class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);

            for (int i = 1; i < freq; i++) {
                goodPairs += i;
            }
        }
        return goodPairs;
    }
}