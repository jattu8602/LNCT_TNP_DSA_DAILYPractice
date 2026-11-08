class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0 , candidates, ans , target, new ArrayList<>());
        return ans ; 

        
    }
    public void findCombinations(int idx, int[] arr , List<List<Integer>> ans , int target, ArrayList<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i = idx ; i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;
            ds.add(arr[i]);
            findCombinations(i+1, arr, ans , target-arr[i] , ds);
            ds.remove(ds.size()-1);

        }
        
    }
}