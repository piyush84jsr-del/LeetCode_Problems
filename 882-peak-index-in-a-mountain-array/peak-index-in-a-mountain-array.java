class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int arr1[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr1[i]=arr[i];
        }
        Arrays.sort(arr1);
        int k=arr1[arr1.length-1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k){
                return i;
            }
        }
        return -1;
    }
}