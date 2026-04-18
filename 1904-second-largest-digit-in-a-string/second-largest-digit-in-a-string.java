import java.util.*;

class Solution {
    public int secondHighest(String s) {
        int last = -1;
        int slast = -1;

        for(int i = 0 ; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int digit = ch-'0';
                if(digit>last){
                    slast = last ;
                    last = digit;
                }
                else if(last>digit && digit >slast){
                    slast = digit;
                }
            }
        }
        return slast;
    }
}