import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ArrayList<Integer>[] tree = new ArrayList[n];
        ArrayList<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = new int[n];
        int[] lastSeen = new int[26];
        int[] previous = new int[n];

        Arrays.fill(lastSeen, -1);
        newParent[0] = -1;

        // Iterative DFS
        int[] stackNode = new int[2 * n];
        boolean[] stackExit = new boolean[2 * n];

        int top = 0;
        stackNode[top] = 0;
        stackExit[top++] = false;

        while (top > 0) {
            int node = stackNode[--top];
            boolean exit = stackExit[top];

            int ch = s.charAt(node) - 'a';

            if (exit) {
                lastSeen[ch] = previous[node];
                continue;
            }

            previous[node] = lastSeen[ch];

            // Find closest ancestor with same character
            if (lastSeen[ch] != -1) {
                newParent[node] = lastSeen[ch];
            } else {
                newParent[node] = parent[node];
            }

            lastSeen[ch] = node;

            // Exit event
            stackNode[top] = node;
            stackExit[top++] = true;

            // Visit children in original tree
            for (int child : tree[node]) {
                stackNode[top] = child;
                stackExit[top++] = false;
            }
        }

        // Build modified tree
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Find traversal order of modified tree
        int[] order = new int[n];
        int idx = 0;

        stackNode[top++] = 0;

        while (top > 0) {
            int node = stackNode[--top];
            order[idx++] = node;

            for (int child : newTree[node]) {
                stackNode[top++] = child;
            }
        }

        // Calculate subtree sizes bottom-up
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}