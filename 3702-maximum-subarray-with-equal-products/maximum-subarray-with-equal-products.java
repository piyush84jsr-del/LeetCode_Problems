
class Solution {
    public int maxLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        int maxNum = 0;
        int maxLcm = 1;

        // Calculate maximum element and LCM of entire array
        for (int x : nums) {
            maxNum = Math.max(maxNum, x);
            maxLcm = lcm(maxLcm, x);
        }

        int maxProduct = maxNum * maxLcm;

        for (int i = 0; i < n; i++) {

            long product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < n; j++) {

                product *= nums[j];

                gcd = gcd(gcd, nums[j]);

                lcm = lcm(lcm, nums[j]);

                if (product == (long) gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }

                if (product > maxProduct) {
                    break;
                }
            }
        }

        return ans;
    }

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
