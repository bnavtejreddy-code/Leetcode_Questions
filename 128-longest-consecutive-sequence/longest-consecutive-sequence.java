class Solution {
    public int longestConsecutive(int[] nums) {
        // if(nums.length==0){
        //     return 0;
        // }
        HashSet<Integer> hash = new HashSet<>();
        for(int i:nums){
           hash.add(i);
        }
        int longest =0;
        for(int num:hash){
            if(!hash.contains(num-1)){
                int current = num;
                int count =1;
                while(hash.contains(current+1)){
                    current = current+1;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}