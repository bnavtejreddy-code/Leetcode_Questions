class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hash=new HashMap<>();
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String res = new String(ch);
            hash.putIfAbsent(res,new ArrayList<>());
            hash.get(res).add(str);
        }
        return new ArrayList<>(hash.values());
    }
}