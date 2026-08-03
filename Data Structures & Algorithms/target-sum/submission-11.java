class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return computeSums(nums, target, 0);
    }

    private int computeSums(int[] nums, int target, int currentIndex) {

        if (currentIndex == nums.length) return (target == 0) ? 1 : 0;

        return computeSums(nums, target+nums[currentIndex], currentIndex+1) + 
                computeSums(nums, target-nums[currentIndex], currentIndex+1);
    }

}
