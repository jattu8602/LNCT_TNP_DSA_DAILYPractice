import java.util.*;


class InfixToPostFix{
  static int p(char c){
    if(c=='+' || c=='-' ) return 1;
    if(c=='*' || c=='/' ) return 2;
    if(c=='^' || c=='$' ) return 3;
    return 0;
  }
  public static void main(String[] args)
{
  Scanner sc = new Scanner(System.in);
  String s = sc.nextLine();

  Stack<Character> st = new Stack<>();

  String ans = "";

  for(char c: s.toCharArray()){
    if(Character.isLetterOrDigit(c)) ans+=c;
  }


}




}

