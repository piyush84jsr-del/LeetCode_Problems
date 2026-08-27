class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] count = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            int current = target.charAt(i) - 'a';

            // Try to use target[i]
            if (count[current] > 0) {

                count[current]--;
                ans.append(target.charAt(i));

            } else {

                // target[i] is not available.
                // Find the smallest character greater than target[i].
                for (int j = current + 1; j < 26; j++) {

                    if (count[j] > 0) {

                        ans.append((char) ('a' + j));
                        count[j]--;

                        // Put remaining characters
                        // in sorted order.
                        for (int k = 0; k < 26; k++) {
                            while (count[k] > 0) {
                                ans.append((char) ('a' + k));
                                count[k]--;
                            }
                        }

                        return ans.toString();
                    }
                }

                /*
                 * We cannot make the answer greater at this
                 * position, so we need to go back and change
                 * an earlier position.
                 */
                
                break;
            }
        }

        // target itself was completely formed.
        // It is NOT strictly greater than target.
        // We need to modify an earlier position.

        // Rebuild from scratch and try changing positions
        // from right to left.
        count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = target.length() - 1; i >= 0; i--) {

            // Use target[0 ... i-1]
            int[] temp = count.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {

                int idx = target.charAt(j) - 'a';

                if (temp[idx] == 0) {
                    possible = false;
                    break;
                }

                temp[idx]--;
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            // Find smallest character > target[i]
            for (int j = current + 1; j < 26; j++) {

                if (temp[j] > 0) {

                    StringBuilder result =
                            new StringBuilder(target.substring(0, i));

                    result.append((char) ('a' + j));
                    temp[j]--;

                    // Add remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (temp[k] > 0) {
                            result.append((char) ('a' + k));
                            temp[k]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }
}