class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans=new int[nums.length];
        int posi = 0;
        int negi = 1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<0){
                ans[negi]=nums[i];
                negi=negi+2;
            }else{
                ans[posi]=nums[i];
                posi = posi+2;
            }
        }
        return ans;
    }
}