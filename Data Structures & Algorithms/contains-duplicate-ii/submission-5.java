class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        

        for (int left = 0; left < nums.length; left++) {

            // element to find in window...
            int find = nums[left];

            for (int i = left+1; i <= Math.min(nums.length - 1, left+k); i++) {
                if (nums[i] == find) return true;
            }

        }
        return false;

    }
}