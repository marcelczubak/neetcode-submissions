class Solution {
    public boolean canPartition(int[] nums) {

        Map<String, Boolean> memo = new HashMap<>();
        
        int sum = 0;
        for (int num : nums) sum += num;

        // If sum not even, partition not possible
        if (sum % 2 != 0) return false;

        return partition(memo, nums, 0, 0, sum/2);

    }

    // Try to form a subset which adds up to target
    private boolean partition(Map<String, Boolean> memo, int[] nums, int i, int curSum, int target) {
        
        String key = String.valueOf(i) + "." + String.valueOf(curSum);

        if (memo.containsKey(key)) return memo.get(key);

        if (curSum == target) return true;
        if (i >= nums.length || curSum > target) return false;

        boolean takeCurrent = partition(memo, nums, i+1, curSum + nums[i], target);

        boolean skipCurrent = partition(memo, nums, i+1, curSum, target);

        memo.put(key, takeCurrent || skipCurrent);

        return takeCurrent || skipCurrent;

    }

}
