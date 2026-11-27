class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        // Step 1: Find the cheapest item
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // Step 2: 0/1 Knapsack
        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            int freeCount = 0;

            // Count how many free items this item provides
            for (int j = 0; j < n; j++) {

                if (i != j && items[j][0] % factor == 0) {
                    freeCount++;
                }
            }

            // First purchase gives the item + free items
            int profit = 1 + freeCount;

            for (int j = budget; j >= price; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + profit
                );
            }
        }

        // Step 3: Use remaining budget to buy cheapest items
        int ans = 0;

        for (int i = 0; i <= budget; i++) {

            int remaining = budget - i;

            int total = dp[i] + remaining / minPrice;

            ans = Math.max(ans, total);
        }

        return ans;
    }
}