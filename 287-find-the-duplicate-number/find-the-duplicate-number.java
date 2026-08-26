class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        // now init the slow to index = 0 
        slow = nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast = nums[fast];
        }
        return slow;













        // int n = nums.length;
        // int exp = n*(n-1)/2;
        // int sum = 0 ; 

        // for(int i:nums){
        //     sum+=i;



        // }
        // if(sum/nums.length==nums[0]){
        //     return nums[0];
        // }
        // return sum-exp;
        
    }
}