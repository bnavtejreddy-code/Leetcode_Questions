class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixsum=0;
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer> prefix=new HashMap<>();
        prefix.put(0,1);
        for(int i =0;i<n;i++){
            prefixsum=prefixsum+nums[i];
            int remove = prefixsum-k;
            if(prefix.containsKey(remove)){
                count=count+prefix.get(remove);
            }
            prefix.put(prefixsum,prefix.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}