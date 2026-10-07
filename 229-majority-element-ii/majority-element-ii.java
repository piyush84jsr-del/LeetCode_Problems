import java.util.HashMap;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        ArrayList<Integer> k=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        for(int i:h.keySet()){
            if(h.get(i)>nums.length/3){
                k.add(i);
            }
            
        }
        Collections.sort(k);
        return k;
    }
}