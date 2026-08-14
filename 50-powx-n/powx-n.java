class Solution {
    public double myPow(double x, int n) {

        // Convert n to long because -2147483648
        // cannot be safely converted to positive int.
        long power = n;

        // Handle negative exponent
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        // Result starts at 1 because x^0 = 1
        double result = 1;

        // Binary exponentiation
        while (power > 0) {

            // If power is odd, use the current x
            if (power % 2 == 1) {
                result = result * x;
            }

            // Square x for the next step
            x = x * x;

            // Divide exponent by 2
            power = power / 2;
        }

        return result;
    }
}