class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] freq = new int[51];

        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                freq[-nums[i]]++;
            }
        }

        ans[0] = findBeauty(freq, x);

        for (int i = k; i < n; i++) {

            if (nums[i - k] < 0) {
                freq[-nums[i - k]]--;
            }

            if (nums[i] < 0) {
                freq[-nums[i]]++;
            }

            ans[i - k + 1] = findBeauty(freq, x);
        }

        return ans;
    }

    public int findBeauty(int[] freq, int x) {

        int count = 0;

        for (int i = 50; i >= 1; i--) {
            count += freq[i];

            if (count >= x) {
                return -i;
            }
        }

        return 0;
    }
}