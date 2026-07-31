class Solution {

    public String frequencySort(String s) {

        // Frequency Map
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Store every character
        List<Character> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            list.add(ch);
        }

        // Sort by decreasing frequency
        Collections.sort(list, (a, b) -> {

            // Higher frequency comes first
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            // If frequencies are equal,
            // any order is acceptable.
            return a - b;
        });

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (char ch : list) {
            ans.append(ch);
        }

        return ans.toString();
    }
}