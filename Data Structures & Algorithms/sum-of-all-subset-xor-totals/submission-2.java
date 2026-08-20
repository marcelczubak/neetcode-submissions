class Solution {
    public int subsetXORSum(int[] nums) {
        return xorSubsets(nums, 0, 0);
    }

    private int xorSubsets(int[] nums, int index, int xorSum) {

        if (index >= nums.length) return xorSum;

        int include = xorSubsets(nums, index+1, xorSum^nums[index]);
        int exclude = xorSubsets(nums, index+1, xorSum);

        return include + exclude;
    }
}