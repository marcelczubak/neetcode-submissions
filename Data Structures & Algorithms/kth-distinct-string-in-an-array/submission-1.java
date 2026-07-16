class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Map<String, Integer> map = new HashMap<>();

        for(String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int distinctElement = 0;


        for(String s : arr) {

            if (map.get(s) == 1) {
                distinctElement++;
            }
            if (distinctElement == k) return s;

        }

        return "";

    }
}