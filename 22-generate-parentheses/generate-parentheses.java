class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String curr, int open, int close, int n) {

        // Base case
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(ans, curr + "(", open + 1, close, n);
        }

        // Add closing bracket
        if (close < open) {
            backtrack(ans, curr + ")", open, close + 1, n);
        }
    }
}