class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0 ; 
        int high = n-1;
        int mid = 0 ; 

while(mid<=high)
    {
            if(nums[mid]==0){
                swap(nums , low , mid);
                low++;
                mid++;

            } else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums , mid , high );
                high--;
                // mid++;
            }
           
        }




























        // int z = 0 ; 
        // int o = 0; 
        // int t = 0 ; 
        // for(int i = 0 ; i<nums.length;i++){
        //     if(nums[i] == 0 )z++;
        //     if(nums[i]==1)o++;
        //     if(nums[i]==2)t++;


        // }
        // for(int i = 0 ; i<z ;i++){
        //     nums[i] = 0;
        // }
        //  for(int i = z ; i<z+o ;i++){
        //     nums[i] = 1;
        // }
        //  for(int i = z+o ; i<t+z+o ;i++){
        //     nums[i] = 2;
        // }




        









        // for(int i = 0 ; i<nums.length-1;i++){
        //     for(int j = 1 ; j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             break;
        //         }
        //         if(nums[i]>nums[j]){
        //             int temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }


        
    }
    public void swap(int[] nums , int a , int b ){
        int temp = nums[a] ; 
        nums[a]  = nums[b] ; 
        nums[b] = temp;
    }
}