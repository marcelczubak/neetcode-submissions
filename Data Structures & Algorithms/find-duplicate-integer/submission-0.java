class Solution {
    public int findDuplicate(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);

            // get the value at index num
            int index = num - 1;

            if (nums[index] < 0) {
                return num;
            } else {
                nums[index] *= -1; // mark
            }



        }
        return -1;

    }
}
