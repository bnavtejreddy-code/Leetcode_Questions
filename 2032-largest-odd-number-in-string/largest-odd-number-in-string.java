class Solution {
    public String largestOddNumber(String num) {
        int i ;
        int ind=-1;
        for( i = num.length()-1;i>=0;i--){
            if((num.charAt(i))%2 == 1){
                ind=i;
                break;
            }
            
        }
        if(ind==-1){
            return "";
        }
        return num.substring(0,ind+1);
        
    }
}