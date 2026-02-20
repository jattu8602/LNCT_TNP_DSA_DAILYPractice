// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution {
    public boolean check(int[] nums) {
        int count = 0 ;
        int n = nums.length;

        for(int i = 0 ;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                count ++;

            }
            if(count >1){return false;}


        }
          return true ;

    }
}

//  static inner class  -
// inner class -
//  this  keyword usage
//  hybrid , multilevel , nultiple , single , hirearchical inheritance
//  variable , methods ,  constructors , blocks , inner class
// what is inheritance ? - one class can aquire all the properties of another class is known as inheritance 
