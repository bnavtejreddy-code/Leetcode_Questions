class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        int count = 0;
        HashMap<Integer,Integer> hash=new HashMap<>();
        hash.put(0,1);
        for(int i = 0;i<nums.length;i++){
            prefix = prefix + nums[i];
            int search = prefix-k;
            if(hash.containsKey(search)){
                count=count + hash.get(search);

            }
            hash.put(prefix,hash.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}