class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> hash=new HashMap<>();
        int n = nums.length;
        int mini=(n/3)+1;
        for(int i =0;i<nums.length;i++){
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
            if(mini==hash.get(nums[i])){
                res.add(nums[i]);
            }
        }
        return res;
    }
}