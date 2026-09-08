class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        Stack<Integer> s = new Stack<>();

        s.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == s.peek()) {
                s.push(nums[i]);
            } 
            else {
                if (s.size() > nums.length / 2) {
                    return s.peek();
                }

                s.clear();
                s.push(nums[i]);
            }
        }

        // Check the last group
        if (s.size() > nums.length / 2) {
            return s.peek();
        }

        return -1;
    }
}