// https://leetcode.com/problems/house-robber-ii/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];

        int case1 = helper(nums , 0 , n-2);
        int case2 = helper(nums , 1 , n-1);

        return Math.max(case1, case2);




    }
    public int helper (int[] nums ,int start ,int end ){

        int prev2  =  0;
        int prev1 = 0 ;

        for (int i  = start ; i <=end ;i++){
            int skip  = prev1;
            int pick = nums[i] + prev2;

            int current = Math.max(skip , pick );

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;




    }
}




// using dp : preffered way is above one because it saved the space complexity 


class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int case1 = robLinear(nums, 0, n - 2);
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {

        int size = end - start + 1;

        int[] dp = new int[size];

        // Base cases
        dp[0] = nums[start];

        if (size == 1) return dp[0];

        dp[1] = Math.max(nums[start], nums[start + 1]);

        // Fill DP array
        for (int i = 2; i < size; i++) {
            dp[i] = Math.max(
                dp[i - 1],                          // skip
                nums[start + i] + dp[i - 2]         // pick
            );
        }

        return dp[size - 1];
    }
}