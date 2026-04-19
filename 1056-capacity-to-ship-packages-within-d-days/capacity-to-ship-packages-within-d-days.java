class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0 ; 
        int right = 0 ; 
        for( int w : weights){
            left = Math.max(left , w);
            right +=w;
        }

        while(left<right){
            int mid = left + (right -left)/2;
            if(canShip(weights , days , mid)){
                right = mid;
                
            }else{
                left = mid+1;
            }
        }
        return left;


        
    }
    boolean canShip(int[] weights ,int  days , int capacity){
        int totaldays = 1 ; 
        int canLoad = 0;
        for(int w : weights){
            if(canLoad+w>capacity){
                totaldays ++;
                canLoad = w; 
            }
            else{
                canLoad +=w;
            }
        }
        return totaldays<=days;
        
    }
}