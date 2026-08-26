class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int first = -1;
        int second = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                count++;

                if (count == 1) {
                    first = i;
                } else if (count == 2) {
                    second = i;
                } else {
                    return false;
                }
            }
        }

        // Already equal
        if (count == 0) {
            return true;
        }

        // Exactly two differences:
        // s1[first] should match s2[second]
        // s1[second] should match s2[first]
        return count == 2 &&
               s1.charAt(first) == s2.charAt(second) &&
               s1.charAt(second) == s2.charAt(first);
    }
}