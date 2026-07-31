class Solution {

    public String frequencySort(String s) {

        // Result array to store the final answer
        char[] res = new char[s.length()];

        // Frequency array for all ASCII characters
        int[] freq = new int[128];

        // Count the frequency of every character
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        // Index where we will insert characters into the result
        int ind = 0;

        // Continue until the result array is completely filled
        while (ind < s.length()) {

            // Stores the maximum frequency found
            int max = 0;

            // Stores the character having the maximum frequency
            char maxch = 0;

            // Find the character with the highest frequency
            for (int i = 0; i < 128; i++) {

                if (freq[i] > max) {
                    max = freq[i];
                    maxch = (char) i;
                }
            }

            // Place the character 'maxch' exactly 'max' times
            while (max-- > 0) {
                res[ind++] = maxch;
            }

            // Mark this character as processed
            freq[maxch] = 0;
        }

        // Convert character array into String
        return new String(res);
    }
}