/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = findPeak(mountainArr, n);

        int left = BS(mountainArr, target, 0 , peak , true);
        if(left!=-1){
            return left;
        }
        return BS(mountainArr ,target , peak+1, n-1, false );
        
    }
    public int BS(MountainArray arr , int target , int low , int high , boolean asc){

        while(low<=high){

            int mid = low + (high - low)/2;
        int val = arr.get(mid); 
        if(val == target ) return mid;
        if(asc){
            if(val<target){
                low = mid+1;

            }else{
                high = mid - 1 ;
            }
        }else{
            if(val<target){
             high = mid - 1;;

            }else{
                low = mid + 1;
            }

        }

        }
        return -1;
    }

    public int findPeak(MountainArray arr, int n){
        int low = 0 ; 
        int high = n-1;

        while(low<high){
            int mid = low + (high - low)/2;

            if(arr.get(mid)>arr.get(mid+1)){
                high = mid; 
            }else{
                low = mid+1;
            }
            

    
        }
        return low;
    }
}