class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set  = new HashSet<>();
        int max = 0 ; 
        int left = 0 ; 
        for(int right= 0 ;right<s.length();right++){
            // first check if already present the current element in hashset and remove the element from last 
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            // now add to set
            set.add(s.charAt(right));
            // now max calculate
            max = Math.max(max , right - left+1);
        }
        return max;

        
    }
}