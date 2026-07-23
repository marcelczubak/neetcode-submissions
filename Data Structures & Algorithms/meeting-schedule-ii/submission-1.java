/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        List<Integer> rooms = new ArrayList<>();

        boolean roomAdded = false;

        for(Interval interval : intervals) {

            roomAdded = false;

            if (rooms.isEmpty()) {
                rooms.add(interval.end);
            } else {

                for (int i = 0; i < rooms.size(); i++) {
                    if (rooms.get(i) <= interval.start) {
                        rooms.set(i, interval.end);
                        roomAdded = true;
                        break;
                    }
                }
                if (!roomAdded) rooms.add(interval.end);


            }
        }
        return rooms.size();
    }
}
