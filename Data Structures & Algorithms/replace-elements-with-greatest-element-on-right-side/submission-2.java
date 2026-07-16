class Solution {
    public int[] replaceElements(int[] arr) {
        
        int greatestSoFar = arr[arr.length - 1];

        int[] result = new int[arr.length];

        // last element by default
        result[result.length-1] = -1;

        for (int i = arr.length - 1; i >= 1; i--) {
            
            result[i-1] = Math.max(arr[i], greatestSoFar);

            greatestSoFar = Math.max(greatestSoFar, arr[i]);
        }

        return result;
    }
}