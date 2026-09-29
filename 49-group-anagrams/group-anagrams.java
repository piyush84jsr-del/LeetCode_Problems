class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // Convert string to character array
            char[] arr = s.toCharArray();

            // Sort the characters
            Arrays.sort(arr);

            // Convert sorted array back to String
            String key = new String(arr);

            // Create group if it doesn't exist
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original string to its group
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}