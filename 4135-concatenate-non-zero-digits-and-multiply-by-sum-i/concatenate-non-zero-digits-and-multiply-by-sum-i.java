class Solution {
    public long sumAndMultiply(int n) {
        long x = 0 ; 
        long sum = 0 ; 
        long rev = 0 ;


        while(n>0){
            int digit = n%10;
            if(digit!=0){
                rev = rev*10 + digit;
                sum += digit;

            }
            n/=10;


        }
        while(rev>0){
            long digit = rev%10;
            x= x*10+digit;
            rev/=10;
        }
        return sum*x;
        
    }
}