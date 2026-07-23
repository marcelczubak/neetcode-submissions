class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        // Ignore any triplets whose values exceed corresponding target values
        Set<Integer> invalidTriplets = new HashSet<>();
        for (int i = 0; i < triplets.length; i++) {
            int[] triplet = triplets[i];
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) invalidTriplets.add(i);
        }

        boolean foundA = false, foundB = false, foundC = false;

        for (int i = 0; i < triplets.length; i++) {
            int[] triplet = triplets[i];
            
            if (invalidTriplets.contains(i)) continue;

            if (triplet[0] == target[0]) foundA = true;
            if (triplet[1] == target[1]) foundB = true;
            if (triplet[2] == target[2]) foundC = true;

        }

        return (foundA && foundB && foundC);
    }
}
