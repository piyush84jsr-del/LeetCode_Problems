class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        Queue<Integer> q = new LinkedList<>();

        // Store last k elements
        for(int i = nums.length - k; i < nums.length; i++) {
            q.add(nums[i]);
        }

        // Shift remaining elements to the right
        for(int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Put queue elements at beginning
        int i = 0;
        while(!q.isEmpty()) {
            nums[i] = q.poll();
            i++;
        }
    }
}