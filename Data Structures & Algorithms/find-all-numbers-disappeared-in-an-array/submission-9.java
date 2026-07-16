class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // If number |n| encountered, mark index n-1    

        // Traverse nums. Any unmarked indices (+1) have not been included in nums


        for (int num : nums) {
            // If unmarked, mark index
            if (nums[Math.abs(num)-1] > 0) nums[Math.abs(num)-1] *= -1;

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i+1);
        }

        return result;
    }
}



// O(N) space!!

// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
        
//         boolean[] seen = new boolean[nums.length];

//         for (int num : nums) {
//             seen[num-1] = true;
//         }

//         List<Integer> result = new ArrayList<>();

//         for(int i = 0; i < seen.length; i++) {
//             if (!seen[i]) result.add(i+1);
//         }
//         return result;
//     }
// }