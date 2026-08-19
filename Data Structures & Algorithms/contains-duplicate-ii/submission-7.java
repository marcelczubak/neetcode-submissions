// O(nk) IMPLEMENTATION   ... O(1) space!!

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {

//         for (int left = 0; left < nums.length; left++) {
//             for (int i = left+1; i <= Math.min(nums.length - 1, left+k); i++) {
//                 if (nums[left] == nums[i]) return true;
//             }
//         }

//         return false;
//     }
// }



// HASHMAP IMPLEMENTATION   ... O(n), O(n)


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int element = nums[i];

            if (indexMap.containsKey(element) && (i - indexMap.get(element) <= k)) return true;

            indexMap.put(element, i);
            



        }

        return false;

    }
}