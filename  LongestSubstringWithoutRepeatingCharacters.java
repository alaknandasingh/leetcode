class Solution {

    public int lengthOfLongestSubstring(String s) {
        int global = 0, local = 0;
        Map<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int index = map.get(s.charAt(i));
                global = (local > global)? local: global;
                int length = 0;
                length = index-(i-local)+1;
                for (int j = i-local; j < i-local+length; j++) {
                    map.remove(s.charAt(j));
                }
                local = local - length;
            } 
                map.put(s.charAt(i),i);
                local++;
        }
        global = (local > global)? local: global;
        
        return global;
        
    }
}