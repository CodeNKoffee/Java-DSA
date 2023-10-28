/**
 * Given a string, this program reverses it using a stack.
 *
 * Example:
 *
 * Input: str = "GeeksQuiz"
 * Output: ziuQskeeG
 *
 * Input: str = "abc"
 * Output: cba
 *
 * Approach:
 * The idea is to create an empty stack and push all the characters from the string into it.
 * Then pop each character one by one from the stack and put them back into the input string
 * starting from the 0’th index. Stacks work on the principle of first in, last out, so after
 * popping all the elements and placing them back in the string, the result will be the reversed
 * string.
 */

public class ReverseString {
  public static String reverseString(String str) {
    if (str == null || str.length() <= 1)
      return str;
    else {
      StackObj stack = new StackObj(str.length());

      for (int i = 0; i < str.length(); i++) {
        stack.push(str.charAt(i));
      }

      StringBuilder reversedString = new StringBuilder();

      while (!stack.isEmpty())
        reversedString.append((char) stack.pop());

      return reversedString.toString();
    }
  }

  public static void main(String[] args) {
    String str = "GeeksQuiz";
    System.out.println(reverseString(str));
  }
}

// Push characters onto the stack and reverse the string by popping.
// Stack's LIFO property reverses the characters efficiently.
