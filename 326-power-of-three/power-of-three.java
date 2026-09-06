class Solution {
    public boolean isPowerOfThree(int n) {
        double k = n;
        while(k>1){
            k=k/3;

        }
        if(k==1){
            return true;
        }else{
            return false;
        }                                
    }
}