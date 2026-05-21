class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();
        
        // Go through all strings
        for (int i = 0; i < strs.length; i++) {
            if(!strs[i].equals("XXX")){
                char[] charArr = strs[i].toCharArray();
                Arrays.sort(charArr);

                // Create subarray
                List<String> subarray = new ArrayList<String>();
                subarray.add(strs[i]);

                // Mark strs[i] as used
                strs[i] = "XXX";

                // Check forward
                for (int j = i+1; j < strs.length; j++) {
                    if(!strs[j].equals("XXX")) {
                        char[] charArr2 = strs[j].toCharArray();
                        Arrays.sort(charArr2);

                        if(Arrays.equals(charArr, charArr2)) {
                            subarray.add(strs[j]);
                            // Mark strs[j] as used
                            strs[j] = "XXX";
                        }
                    }
                    
                }
                result.add(subarray);
            }    
        }

        return result;
    }
}
