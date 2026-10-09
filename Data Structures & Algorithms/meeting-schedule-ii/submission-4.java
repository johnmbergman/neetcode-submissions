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
    public int minMeetingRooms(final List<Interval> intervals) {
        final Queue<Integer> heap = new PriorityQueue<>();
        intervals.sort((a, b) -> a.start - b.start);

        for (final Interval interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval.start) {
                heap.poll();
            }
            heap.add(interval.end);
        }
        return heap.size();
    }
}
