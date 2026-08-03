class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return computeSums(nums, target, 0, 0);

    }

    private int computeSums(int[] nums, int target, int currentSum, int currentIndex) {

        if (currentIndex == nums.length) return (currentSum == target) ? 1 : 0;

        return computeSums(nums, target, currentSum+nums[currentIndex], currentIndex + 1) + 
        computeSums(nums, target, currentSum-nums[currentIndex], currentIndex + 1);
    }

}
