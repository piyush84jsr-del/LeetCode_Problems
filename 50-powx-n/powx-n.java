class Solution {
    public double myPow(double x, int n) {
        long N = n;
        double ans = 1.0;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        while (N > 0) {
            if ((N & 1) == 1) {   // if N is odd
                ans *= x;
            }

            x *= x;               // square the base
            N /= 2;               // divide exponent by 2
        }

        return ans;
    }
}