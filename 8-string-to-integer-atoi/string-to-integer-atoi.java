class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        int number = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Check overflow
            if (number > Integer.MAX_VALUE / 10 ||
               (number == Integer.MAX_VALUE / 10 && digit > 7)) {

                if (sign == 1)
                    return Integer.MAX_VALUE;

                return Integer.MIN_VALUE;
            }

            // Build number
            number = number * 10 + digit;

            i++;
        }

        return sign * number;
    }
}