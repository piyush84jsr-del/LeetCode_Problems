class Solution {
    public int smallestNumber(int n, int t) {
        int r,p=1,m=n;
        while(m!=0){
            r=m%10;
            p=p*r;
            m=m/10;
        }
        if(p%t==0){
            return n;
        }else{
            return smallestNumber(n+1,t);
        }
    }
}