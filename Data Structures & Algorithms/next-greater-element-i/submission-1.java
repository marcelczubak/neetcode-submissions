class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
          
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            } 

            stack.push(num);

        }

        for (int i = 0; i < nums1.length; i++) {
            if(!map.containsKey(nums1[i])) result[i] = -1;
            else result[i] = map.get(nums1[i]);
        }

        return result;
    }
}