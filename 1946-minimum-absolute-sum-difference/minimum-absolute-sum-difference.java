import java.util.*;

class Solution {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        // Answer has to be returned modulo 10^9 + 7
        final int MOD = 1_000_000_007;


        // =========================================================
        // STEP 1: Make a sorted copy of nums1
        // =========================================================
        //
        // Why do we need a sorted copy?
        //
        // We want to quickly find the number in nums1
        // that is closest to nums2[i].
        //
        // Binary Search works on a sorted array.
        //
        // IMPORTANT:
        // We don't sort nums1 directly because we still need
        // the original nums1 values for calculating the
        // original difference.
        //
        int[] sorted = nums1.clone();

        Arrays.sort(sorted);


        // Example:
        //
        // nums1  = [1, 7, 5]
        //
        // sorted = [1, 5, 7]


        // =========================================================
        // STEP 2: Calculate the original total difference
        // =========================================================
        //
        // Also keep track of the maximum amount we can SAVE
        // by changing one element.
        //
        long total = 0;
        long maxSaving = 0;


        // Go through every position
        for (int i = 0; i < nums1.length; i++) {


            // -----------------------------------------------------
            // Current difference at this position
            // -----------------------------------------------------
            //
            // Example:
            //
            // nums1[i] = 7
            // nums2[i] = 3
            //
            // currentDiff = |7 - 3|
            //             = 4
            //
            long currentDiff =
                Math.abs((long) nums1[i] - nums2[i]);


            // Add this difference to the original total.
            //
            // Example:
            //
            // total = 1 + 4 + 0
            //       = 5
            //
            total += currentDiff;


            // =====================================================
            // STEP 3: Find the closest value to nums2[i]
            // =====================================================

            int target = nums2[i];


            // We want to find 'target' inside sorted[].
            //
            // Arrays.binarySearch() behaves like this:
            //
            // If target exists:
            //     returns its index.
            //
            // If target doesn't exist:
            //     returns a negative value telling us
            //     where target would be inserted.
            //
            int pos = Arrays.binarySearch(sorted, target);


            // -----------------------------------------------------
            // If target was NOT found
            // -----------------------------------------------------
            //
            // Suppose:
            //
            // sorted = [1, 5, 7]
            // target = 3
            //
            // 3 would be inserted at index 1:
            //
            // [1, 3, 5, 7]
            //    ↑
            //
            // binarySearch returns:
            //
            // -(1) - 1 = -2
            //
            // So we convert it back:
            //
            // pos = -(-2) - 1
            //     = 1
            //
            if (pos < 0) {
                pos = -pos - 1;
            }


            // =====================================================
            // STEP 4: Check sorted[pos]
            // =====================================================
            //
            // pos is the first position where target could
            // be inserted.
            //
            // Therefore sorted[pos] is the number just
            // GREATER than or EQUAL to target.
            //
            // Example:
            //
            // sorted = [1, 5, 7]
            // target = 3
            //
            // pos = 1
            //
            // sorted[pos] = 5
            //
            if (pos < sorted.length) {

                // What would the difference be if we replace
                // nums1[i] with sorted[pos]?
                //
                // Example:
                //
                // target = 3
                // sorted[pos] = 5
                //
                // newDiff = |5 - 3|
                //         = 2
                //
                long newDiff =
                    Math.abs((long) sorted[pos] - target);


                // Current difference:
                //
                // |7 - 3| = 4
                //
                // New difference:
                //
                // |5 - 3| = 2
                //
                // Saving:
                //
                // 4 - 2 = 2
                //
                long saving = currentDiff - newDiff;


                // Keep the BEST saving found so far.
                //
                maxSaving = Math.max(maxSaving, saving);
            }


            // =====================================================
            // STEP 5: Check sorted[pos - 1]
            // =====================================================
            //
            // There is another possible closest value:
            //
            // sorted[pos - 1]
            //
            // This is the number just SMALLER than target.
            //
            // We must check both sides.
            //
            // Example:
            //
            // sorted = [1, 5, 7]
            // target = 3
            //
            // pos = 1
            //
            // sorted[pos]     = 5
            // sorted[pos - 1] = 1
            //
            // Both need to be checked.
            //
            if (pos > 0) {

                long newDiff =
                    Math.abs((long) sorted[pos - 1] - target);


                // How much would this replacement save?
                long saving = currentDiff - newDiff;


                // Keep the maximum saving.
                maxSaving = Math.max(maxSaving, saving);
            }
        }


        // =========================================================
        // STEP 6: Calculate final answer
        // =========================================================
        //
        // We already know the original total.
        //
        // maxSaving = maximum reduction possible by
        //              changing ONE element.
        //
        // Therefore:
        //
        // final answer = original total - maximum saving
        //
        long answer = total - maxSaving;


        // Return modulo 10^9 + 7
        return (int) (answer % MOD);
    }
}