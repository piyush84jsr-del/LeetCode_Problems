class Solution {

    public int largest(int n, int num[]) {
        int max = num[n + 1];

        for (int i = n + 2; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }

        return max;
    }

    public int[] replaceElements(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length - 1; i++) {
            result[i] = largest(i, arr);
        }

        result[arr.length - 1] = -1;

        return result;
    }
}