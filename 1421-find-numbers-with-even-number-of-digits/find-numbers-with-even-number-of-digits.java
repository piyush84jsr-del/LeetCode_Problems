class Solution {
     int m=0;
    public void digit(int n){
        int c=0;
        while(n!=0){
            int r=n%10;
            c++;
            n=n/10;
        }
        if(c%2==0){
            m++;
        }
        
    }
    public int findNumbers(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            digit(nums[i]);
        }
        return m;
    }
}