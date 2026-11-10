class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();boolean[] freq = new boolean[nums.length];
        solve(nums , freq, ans , new ArrayList<>());
        return ans;
    }
    public void solve(int[] nums , boolean[] freq, List<List<Integer>> ans , List<Integer> ds){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i= 0 ;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                solve(nums, freq, ans, ds);
                ds.remove(ds.size()-1);
                freq[i] = false;



            }
        }
       
    }
}