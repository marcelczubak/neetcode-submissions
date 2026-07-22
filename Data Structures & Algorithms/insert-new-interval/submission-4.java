class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultList = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int numIntervals = intervals.length;
        boolean inserted = false;

        // Iterate all intervals
        for (int i = 0; i < numIntervals; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Current interval before new interval
            if (currentEnd < newStart) {
                resultList.add(intervals[i]);

            // Current interval after new interval
            } else if (currentStart > newEnd) {

                // Update merged interval before adding
                newInterval[0] = newStart;
                newInterval[1] = newEnd;

                resultList.add(newInterval);
                inserted = true;

                for (int j = i; j < numIntervals; j++) {
                    resultList.add(intervals[j]);
                }
                break;

            } else {
                // Merge overlap
                newStart = Math.min(newStart, currentStart);
                newEnd = Math.max(newEnd, currentEnd);
            }
        }

        // New interval belongs at the end
        if (!inserted) {
            newInterval[0] = newStart;
            newInterval[1] = newEnd;
            resultList.add(newInterval);
        }

        int[][] resultArray = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}