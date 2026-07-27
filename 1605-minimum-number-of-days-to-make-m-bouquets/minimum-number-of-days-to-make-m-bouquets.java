class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if((long)m*k>bloomDay.length){
            return -1;
        }
        for(int i : bloomDay){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        
        while(min<=max){
            int mid = min+(max-min)/2;
            if(CanDo(bloomDay,mid,m,k)){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return min;
    }
    public boolean CanDo(int [] bloomDay,int mid,int m, int k){
        int count=0;
        int total=0;
        for(int i : bloomDay){
            if(i<=mid){
                count = count+1;
            }else{
                total = total+(count/k);
                count=0;
            }
            
        }
        total = total+(count/k);
        return (total>=m);
    }
}