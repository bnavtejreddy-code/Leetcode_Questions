import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        // HashSet stores the characters currently
        // present inside our sliding window.
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        // right expands the window
        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // If current character already exists,
            // the window has a duplicate.
            //
            // Remove characters from the left until
            // the duplicate is removed.
            while (set.contains(current)) {

                set.remove(s.charAt(left));
                left++;
            }

            // Now current character is not duplicated,
            // so add it to the window.
            set.add(current);

            // Current window:
            //
            // left ........ right
            //
            // Length = right - left + 1
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}