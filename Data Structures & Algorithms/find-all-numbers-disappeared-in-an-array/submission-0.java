class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        boolean[] seen = new boolean[nums.length];

        for (int num : nums) {
            seen[num-1] = true;
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < seen.length; i++) {
            if (!seen[i]) result.add(i+1);
        }
        return result;
    }
}