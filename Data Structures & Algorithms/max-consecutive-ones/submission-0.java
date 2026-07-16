class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int thisIteration = 0;

        for (int num : nums) {
            if(num == 1) thisIteration++;
            else thisIteration = 0;

            max = Math.max(max, thisIteration);
        }

        return max;

    }
}