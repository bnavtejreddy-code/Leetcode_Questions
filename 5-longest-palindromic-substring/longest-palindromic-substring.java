class Solution {
    
    int maxlength = 0;
    int start =0;
    public String longestPalindrome(String s) {
        int n = s.length();
        if(s.length()<=1) return s;

        for(int i =0;i<n;i++){
             expand(s,i,i);
             expand(s,i,i+1);
        }
        return s.substring(start,start+maxlength);
    }

    public void expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int len = right - left - 1;
        if(len>maxlength){
            start = left+1;
            maxlength = len;
        }
    }
}