class Solution {
    public boolean isMonotonic(int[] nums) {
        
        boolean increasing = (nums[1] >= nums[0]);

        for (int i = 2; i < nums.length; i++) {

            if (increasing && nums[i] < nums[i-1]) return false;
            if (!increasing && nums[i] > nums[i-1]) return false;
        }

        return true;

    }
}