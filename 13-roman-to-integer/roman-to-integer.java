class Solution {

    public int romanToInt(String s) {

        // Stores value of every Roman character
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        // Traverse till second last character
        for (int i = 0; i < s.length() - 1; i++) {

            // Current Roman value
            int current = map.get(s.charAt(i));

            // Next Roman value
            int next = map.get(s.charAt(i + 1));

            // Smaller value before larger value
            // Example: IV, IX, XL
            if (current < next) {
                ans -= current;
            }

            // Normal case
            else {
                ans += current;
            }
        }

        // Last character is always added
        ans += map.get(s.charAt(s.length() - 1));

        return ans;
    }
}