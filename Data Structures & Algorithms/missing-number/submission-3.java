class Solution {
    public int missingNumber(int[] nums) {
        
        // XOR all numbers from 0 to n
        int a = 0;

        for (int i = 1; i < nums.length+1; i++) {
            a ^= i;
        }

        // XOR all elements in the list
        for (int num : nums) {
            a ^= num;
        }

        return a;
    }
}
