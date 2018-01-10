/*
https://leetcode.com/problems/merge-intervals/description/
56. Merge Intervals
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1) return new ArrayList<Interval>();
        intervals.sort((o1, o2) -> o1.start - o2.start);
        List<Interval> list = new ArrayList<>();
        Interval prevInt = intervals.get(0);
        int preStart = prevInt.start;
        int preStop = prevInt.end;
        for(Interval i : intervals){
            if(preStop < i.start){
                list.add(new Interval(preStart, preStop));
                preStart = i.start;
                preStop = i.end;
                continue;
            }
            if(preStop < i.end) preStop = i.end;
        }
        list.add(new Interval(preStart, preStop));
 		//intervals.forEach(o -> System.out.println("[" + o.start + ", " + o.end+ "]"));
        //list.forEach(o -> System.out.println("[" + o.start + ", " + o.end+ "]"));
        return list;
    }
}