class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int maxBs = 0;

        // find the window of length k with the max number of B
        int left = 0; 
        int right = k-1;

        while (right < blocks.length()) {
            int count = 0;
            for (int i = left; i < right+1; i++) {
                
                if (blocks.charAt(i) == 'B') count++;

                maxBs = Math.max(maxBs, count);
                
            }
            left++;
            right++;
        }

        return k - maxBs;

    }
}