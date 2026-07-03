class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        
        int max=0;
        if(nums.length==0){
            return 0;
        }
        int con=nums[0];
        for(int i=1;i<nums.length;i++){
            if(con==nums[i]){
                continue;
            }else if(con+1==nums[i]){
                count++;
                max = Math.max(max,count);
                con=nums[i];
                continue;
            }
            
            count=0;
            con=nums[i];
        }
        return max+1;
    }
}