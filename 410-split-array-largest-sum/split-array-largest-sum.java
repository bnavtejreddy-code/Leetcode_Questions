class Solution {

    public int splitArray(int[] nums, int k) {

        // =====================================================
        // STEP 1: Find the binary search range
        // =====================================================

        // The answer cannot be smaller than the largest
        // element in the array.
        //
        // Example:
        // [7,2,5,10,8]
        //
        // largest element = 10
        //
        // So minimum possible answer = 10
        long left = 0;


        // The maximum possible answer is the sum of
        // the entire array.
        //
        // If we put everything into one subarray:
        //
        // [7,2,5,10,8]
        //
        // sum = 32
        //
        // So maximum possible answer = 32
        long right = 0;


        for (int num : nums) {

            // Find maximum element
            left = Math.max(left, num);

            // Find total sum
            right += num;
        }


        // =====================================================
        // STEP 2: Binary search for the minimum possible
        //         largest subarray sum
        // =====================================================

        while (left < right) {

            // Try the middle value as our maximum allowed
            // subarray sum.
            long mid = left + (right - left) / 2;


            // Check whether we can split the array into
            // k or fewer subarrays where every subarray
            // has sum <= mid.
            //
            // Start with one subarray.
            int pieces = 1;

            long currentSum = 0;


            // Go through the array and create subarrays.
            for (int num : nums) {

                // If adding num doesn't exceed mid,
                // keep it in the current subarray.
                if (currentSum + num <= mid) {

                    currentSum += num;

                } else {

                    // Adding num would make the current
                    // subarray too large.
                    //
                    // So start a NEW subarray.
                    pieces++;

                    currentSum = num;
                }
            }


            // =================================================
            // STEP 3: Decide which half of binary search to use
            // =================================================

            if (pieces <= k) {

                // We successfully split the array using
                // k or fewer pieces.
                //
                // Therefore mid CAN be the answer.
                //
                // But maybe we can make it even smaller.
                //
                // Search the left half.
                right = mid;

            } else {

                // We needed MORE than k subarrays.
                //
                // Therefore mid is too small.
                //
                // We need to allow larger subarray sums.
                //
                // Search the right half.
                left = mid + 1;
            }
        }


        // When left == right, we've found the smallest
        // possible maximum subarray sum.
        return (int) left;
    }
}