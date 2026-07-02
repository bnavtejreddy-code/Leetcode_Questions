class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p=nums.length;
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<p;i++){
            int search = target-nums[i];
            if(hash.containsKey(search)){
                return new int[]{hash.get(search),i};
            }
            else{
                hash.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}