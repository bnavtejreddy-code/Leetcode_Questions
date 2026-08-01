class Solution {
    public String frequencySort(String s) {
        
        int[] freq=new int[128];
        char[] res = new char[s.length()];

        for(char ch : s.toCharArray()){
            freq[ch]++;
        }
        int ind = 0;
        while(ind<s.length()){
            int max = 0;
            char maxch=0 ;
            for(int i =0;i<freq.length;i++){
                if(max<freq[i]){
                    max=freq[i];
                    maxch = (char) i ;
                }
            }

        
        while(max-->0){
            res[ind++]=maxch;
        }

        freq[maxch] =0;
        }
        return new String(res);
    }
    
}
