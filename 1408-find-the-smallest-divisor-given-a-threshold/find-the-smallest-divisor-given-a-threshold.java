class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i : nums){
            low = Math.min(low,i);
            high = Math.max(high,i);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(Divi(nums,threshold,mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean Divi(int[] nums,int threshold,int mid){
        int total = 0;
        for(int i:nums){
            total = total+(i+mid-1)/mid;
        }
        return (total<=threshold);
    }
}