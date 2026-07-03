class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int con = Integer.MIN_VALUE; // last smaller element
        int count = 0;               // current sequence length
        int max = 1;                 // longest sequence

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] - 1 == con) {
                count++;
                con = nums[i];
            }
            else if (nums[i] != con) {
                count = 1;
                con = nums[i];
            }

            max = Math.max(max, count);
        }

        return max;
    }
}