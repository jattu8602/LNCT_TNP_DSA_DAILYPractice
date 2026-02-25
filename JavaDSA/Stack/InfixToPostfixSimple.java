import java.util.*;

class InfixToPostfix {

    static int p(char c) {
        if (c=='+' || c=='-') return 1;
        if (c=='*' || c=='/') return 2;
        if (c=='^') return 3;
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> st = new Stack<>();
        String ans = "";

        for (char c : s.toCharArray()) {

            if (Character.isLetterOrDigit(c))
                ans += c;

            else if (c=='(')
                st.push(c);

            else if (c==')') {
                while (st.peek()!='(')
                    ans += st.pop();
                st.pop();
            }

            else {
                while (!st.isEmpty() && p(st.peek())>=p(c))
                    ans += st.pop();
                st.push(c);
            }
        }

        while (!st.isEmpty())
            ans += st.pop();

        System.out.println(ans);
    }
}