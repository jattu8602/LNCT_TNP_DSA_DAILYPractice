class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0 ; 

        /// move all non zero elements at the end 
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }


        }
        // now fill last reamining element 
        while(index<nums.length){
            nums[index] = 0 ; 
            index++;
        }
        
        
    }
}