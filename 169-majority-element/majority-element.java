class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count=0;
        int ele=0;

        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                ele=nums[i];
            }
            else if(ele==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(ele==nums[i]){
                count++;
            }

        }
        if(count>(n/2)){
            return ele;
        }
        return -1;
        }
        
    }
