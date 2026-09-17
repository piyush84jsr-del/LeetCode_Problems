class Solution {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        s = s.replaceAll("[^a-z0-9]", "");

        String k = s;
        String m = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            m = m + s.charAt(i);
        }

        return m.equals(k);
    }
}