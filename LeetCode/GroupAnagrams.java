/*
https://leetcode.com/problems/group-anagrams/description/
49. Group Anagrams
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sorted = new String(strArr);
            map.putIfAbsent(sorted, new ArrayList<String>());
            List<String> anagramList = map.get(sorted);
            anagramList.add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}