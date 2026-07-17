class Solution {
    public void moveZeroes(int[] nums) {
        
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }

           

        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }

}