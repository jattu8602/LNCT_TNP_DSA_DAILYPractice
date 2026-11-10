class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0 , nums , ans );
        return ans;
    }
    public void swap(int a, int b , int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
    public void solve(int idx, int[] nums , List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                ds.add(nums[i]);

            }
            ans.add(new ArrayList<>(ds));
            return;

        }
        for(int i = idx;i<nums.length;i++)
        {
            swap(idx , i , nums);
            solve(idx+1,nums ,ans);
            swap(idx, i , nums);

        }

    }
}