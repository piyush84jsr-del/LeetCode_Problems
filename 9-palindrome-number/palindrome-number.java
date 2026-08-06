class Solution {
    public boolean isPalindrome(int x) {
        int m=x,r,s=0;
        while(m!=0){
            r=m%10;
            s=10*s+r;
            m=m/10;
        }
        if(x<0){
            s=-s;
        }
        if(s==x){
            return true;
        }else{
            return false;
        }
    }
}