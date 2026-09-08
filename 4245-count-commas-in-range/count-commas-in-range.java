class Solution {
    public int countCommas(int n) {
        int i=1000;
        if(n<i){
            return 0;
        }else{
            return n-i+1;
        }
    }
}