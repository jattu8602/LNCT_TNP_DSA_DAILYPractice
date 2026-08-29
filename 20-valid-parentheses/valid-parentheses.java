class Solution {
    public boolean isValid(String s) {
        // valid parenthsis in my way 
        Stack <Character> st = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);

            }
            // on removal 
            else{
                if(st.isEmpty())return false;
                else if(
                    ch==')' && st.peek()=='(' ||
                    ch=='}' && st.peek()=='{' ||
                    ch==']' && st.peek()=='[' 
                ){
                    st.pop();

                }else{
                    return false;
                }

            }
        }
        return st.isEmpty();
        
    }
    
}