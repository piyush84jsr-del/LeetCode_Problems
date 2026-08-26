class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";

        for (int left = 0; left < s.length(); left++) {
            int ones = 0;

            for (int right = left; right < s.length(); right++) {

                if (s.charAt(right) == '1') {
                    ones++;
                }

                if (ones == k) {
                    String current = s.substring(left, right + 1);

                    if (ans.equals("") ||
                        current.length() < ans.length() ||
                        (current.length() == ans.length() &&
                         current.compareTo(ans) < 0)) {

                        ans = current;
                    }

                    // For this left, extending further only makes it longer
                    break;
                }
            }
        }

        return ans;
    }
}