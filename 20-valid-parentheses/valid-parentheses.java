class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='('|| ch=='{'|| ch=='[')st.add(ch);
            else{
                if(st.isEmpty())return false;
                char top = st.peek();
                if(
                    ch==')'&& top!='(' ||
                    ch=='}'&& top!='{' ||
                    ch==']'&& top!='['

                )return false;
                st.pop();
            }
        }
        return  st.isEmpty();


        
    }
}