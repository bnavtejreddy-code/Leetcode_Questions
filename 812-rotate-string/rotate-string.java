class Solution {
    public boolean rotateString(String s, String goal) {
        String doubled = s+s;
        if(s.length()!=goal.length()){
            return false;
        }
        if(doubled.contains(goal)){
            return true;
        }
        return false;
    }
}