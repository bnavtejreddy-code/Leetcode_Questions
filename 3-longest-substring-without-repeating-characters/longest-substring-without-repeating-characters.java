class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<>();
        if(s.isEmpty()){
            return 0;
        }
        int i =0;
        int j =0;
        int max = Integer.MIN_VALUE;
        while(j<s.length()){
            char ch = s.charAt(j);
            while(hash.contains(ch)){
                hash.remove(s.charAt(i));
                i++;
            }
                hash.add(s.charAt(j));
                max = Math.max(max,j-i+1);
                j++;
        }
        return max;
    }
}