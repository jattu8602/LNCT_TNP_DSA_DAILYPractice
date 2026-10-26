class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length-1;
        int sum = 0 ;
        int exp = 0 ; 

        for(int i = 0 ; i<=n; i++){
            sum += nums[i];
            exp += i+1;
        }
        return exp -sum ;

    }
}