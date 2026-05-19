class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int winsum = 0 ; 
        for(int i = 0 ; i<k;i++){
            winsum +=nums[i];
        }
        int maxsum = winsum ;
        for(int end = k;end<nums.length;end++){
            winsum -= nums[end-k];
            winsum +=nums[end];
            maxsum = Math.max(maxsum,winsum );
        
        }
        return (double)maxsum/k;
        
    }
}