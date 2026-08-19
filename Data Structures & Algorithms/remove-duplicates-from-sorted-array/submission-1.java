class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Available slot to fill next sorted element
        int slow = 0;

        // Fast pointer finds that element to fill
        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            } 

        }
        return slow+1;
    }
}