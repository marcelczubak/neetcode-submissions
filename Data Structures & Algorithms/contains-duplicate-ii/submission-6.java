class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int left = 0; left < nums.length; left++) {
            for (int i = left+1; i <= Math.min(nums.length - 1, left+k); i++) {
                if (nums[left] == nums[i]) return true;
            }
        }

        return false;
    }
}