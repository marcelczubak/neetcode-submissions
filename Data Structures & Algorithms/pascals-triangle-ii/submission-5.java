class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        row.add(1);

        for(int i = 1; i < rowIndex+1; i++) {

            List<Integer> prevRow = row;
            row = new ArrayList<>();

            // Create new 'row' based on prevRow
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }

                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
        }
        return row;
    }
}