
class Solution {
    public int maxFrequency(int[] nums, int k) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        int left = 0;
        long sum = 0;
        int maxFreq = 0;

        // Step 2: Sliding window
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // Step 3: Check if cost exceeds k
            while ((long) nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }

            // Step 4: Update max frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}