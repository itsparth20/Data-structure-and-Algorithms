/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
 //https://leetcode.com/submissions/detail/143474740/
 //149. Max Points on a Line
 //INCOMPLETE
class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int zero = 0;
        for(Point t : points){
            try
            {
                int slope = t.y/t.x;
                System.out.println(slope);
                if (slope == 0) throw new java.lang.ArithmeticException();
                map.putIfAbsent(slope, 0);
                map.put(slope, map.get(slope)+1);
                if(max < map.get(slope)) max = map.get(slope);
            }
            catch(java.lang.ArithmeticException e){
                map.putIfAbsent(0, 0);
                map.put(0, map.get(0)+1);
                
            }
        }
        // System.out.println(max);
        return max + map.getOrDefault(0, 0);
    }
}