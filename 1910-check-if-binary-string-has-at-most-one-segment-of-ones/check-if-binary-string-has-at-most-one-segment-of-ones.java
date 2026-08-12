
class Solution {

    public boolean checkOnesSegment(String s) {

        // We scan from left to right.
        //
        // If we ever find "01", it means:
        //
        // previous segment of 1s ended
        //        ↓
        //        0
        //        ↓
        // another 1 begins
        //
        // Therefore there are at least two segments.

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i - 1) == '0'
                    && s.charAt(i) == '1') {

                return false;
            }
        }

        return true;
    }
}