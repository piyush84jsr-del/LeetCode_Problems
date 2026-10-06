class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> s1 = new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                s1.push(s.charAt(i));
            }else{
                if(!s1.isEmpty()){
                    s1.pop();
                }else{
                    count++;
                }
            }
        }
        return count+s1.size();
    }
}