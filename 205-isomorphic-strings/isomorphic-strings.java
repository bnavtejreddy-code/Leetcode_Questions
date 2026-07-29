class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> hash = new HashMap<>();
        for(int i =0;i<n;i++){
            char key = s.charAt(i);
            char val = t.charAt(i);

            if(!hash.containsKey(key)){
                if(!hash.containsValue(val)){
                    hash.put(key,val);
                }else{
                return false;
            }
            }else{
                char old_val = hash.get(key);
                if(old_val!=val){
                    return false;
                }
            }
        }
        return true;
    }
}