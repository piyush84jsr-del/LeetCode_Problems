import java.util.*;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                s.push(nums[i]);
                k = Math.max(k, s.size());
            } else {
                s.clear();
            }
        }

        return k;
    }
}