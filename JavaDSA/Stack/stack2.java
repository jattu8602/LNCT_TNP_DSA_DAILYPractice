import java.util.Scanner;
import java.util.Stack;

public class StackReverse {

    public static String reverseString(String str) {

        // Create a Stack of characters
        Stack<Character> stack = new Stack<>();

        // -------------------------------
        // 👉 STEP 1:
        // Push all characters of string into stack
        // Write your code below
        // -------------------------------
        while(!str.isEmpty()) {
            stack.push(str.charAt(0));
            str = str.substring(1);

        }




        // -------------------------------
        // 👉 STEP 2:
        // Pop characters from stack and
        // build reversed string
        // Write your code below
        // -------------------------------



        // Return reversed string
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseString(input);

        System.out.println("Reversed String: " + result);

        sc.close();
    }
}