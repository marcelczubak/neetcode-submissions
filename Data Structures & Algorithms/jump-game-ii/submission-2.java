class Solution {
    public int jump(int[] nums) {

        if (nums.length <= 1) return 0;
        
        int left = 0;
        int right = nums[0];

        int numJumps = 1;

        while (right < nums.length-1) {

            int prevLimit = right;

            for (int i = left; i <= prevLimit; i++) {
                right = Math.min(Math.max(right, i + nums[i]), nums.length-1);
            }

            left = prevLimit+1;

            numJumps++;
        }





        return numJumps;
    }
}
