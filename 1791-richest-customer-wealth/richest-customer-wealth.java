import java.util.*;

class Solution {
    public int maximumWealth(int[][] accounts) {

        int totalWealth = Integer.MIN_VALUE;


        for(int person = 0 ; person < accounts.length;person++){
            int sum = 0 ;
            for(int wealth = 0;wealth<accounts[person].length;wealth++){
                sum += accounts[person][wealth];
            }
            if(totalWealth<sum){
                totalWealth=sum;
            }

        }
        return totalWealth;

        
    }
}