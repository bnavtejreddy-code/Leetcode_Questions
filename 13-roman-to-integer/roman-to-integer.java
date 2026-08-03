class Solution {
    public static int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int curr = convert(s.charAt(i));
            int next = convert(s.charAt(i + 1));

            if (curr < next) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        sum += convert(s.charAt(s.length() - 1));

        return sum;
    }

    public static int convert(char ch) {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        if (ch == 'M') return 1000;
        return 0;
    }
}