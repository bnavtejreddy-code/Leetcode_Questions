import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Put all unique numbers into a list
        List<Integer> list = new ArrayList<>(freq.keySet());

        // Step 3: Sort numbers based on their frequency
        list.sort((a, b) -> freq.get(a) - freq.get(b));

        // Now numbers with smaller frequency are at the beginning
        // and numbers with larger frequency are at the end.

        // Step 4: Take the last k elements
        int[] result = new int[k];

        int index = 0;

        for (int i = list.size() - k; i < list.size(); i++) {
            result[index++] = list.get(i);
        }

        return result;
    }
}