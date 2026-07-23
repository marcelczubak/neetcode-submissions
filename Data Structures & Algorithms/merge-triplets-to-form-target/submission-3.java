class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int targetA = target[0];
        int targetB = target[1];
        int targetC = target[2];

        // Ignore any triplets whose values exceed corresponding target values
        Set<Integer> invalidTriplets = new HashSet<>();
        for (int i = 0; i < triplets.length; i++) {
            int[] triplet = triplets[i];
            if(triplet[0] > targetA || triplet[1] > targetB || triplet[2] > targetC) invalidTriplets.add(i);
        }

        boolean foundA = false, foundB = false, foundC = false;

        for (int i = 0; i < triplets.length; i++) {
            int[] triplet = triplets[i];
            
            if (invalidTriplets.contains(i)) continue;


            if (triplet[0] == targetA) foundA = true;
            if (triplet[1] == targetB) foundB = true;
            if (triplet[2] == targetC) foundC = true;

        }



        return (foundA && foundB && foundC);

    }
}
