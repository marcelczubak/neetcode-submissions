class Solution {
    public int missingNumber(int[] nums) {
        
        // XOR all numbers from 0 to n
        int a = 0;

        for (int i = 0; i < nums.length+1; i++) {
            a ^= i;
            if (i < nums.length) a ^= nums[i];
        }

        return a;
    }
}
