class Solution {
    public boolean checkDivisibility(int n) {
        int s=0,q=1,r;
        int p=n;
        while(p!=0){
            r=p%10;
            s=s+r;
            q=q*r;
            p=p/10;
        }
        if(n%(s+q)==0){
            return true;
        }else{
            return false;
        }
    }
}