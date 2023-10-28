/**
 * Question: You are given a set of strings which contain only as and bs. Your program should check whether each string
 * has the same number of as and bs in it.
 *
 * Example: The program will respond true if it gets {ab, aabb, aaabbbb, bbbaaa} and say false when it gets
 * {aab, bbba, aaabbbb}.
 */

public class CheckStrings {
  public static void checkString(String s) {
    if (s.length() % 2 != 0) {
      System.out.println("Doesn't satisfy the condition");
      return;
    }

    int n = s.length();
    StackObj stack = new StackObj(n);

    for (int i = 0; i < n; ++i) {
      if (stack.isEmpty() || (char) stack.top() == s.charAt(i)) {
        stack.push(s.charAt(i));
      } else if ((char) stack.top() != s.charAt(i)) {
        stack.pop();
      }
    }

    if (stack.isEmpty()) {
      System.out.println("Yes, satisfies the condition");
    } else {
      System.out.println("Doesn't satisfy the condition");
    }
  }

  public static void testStrings(String[] strings) {
    for (String s : strings) {
      System.out.println("Input: " + s);
      checkString(s);
      System.out.println();
    }
  }

  public static void main(String[] args) {
    String[] testStrings = { "ab", "aabb", "aaabbbb", "bbbaaa", "aab", "bbba", "aaabbbb" };
    testStrings(testStrings);
  }
}

/**
 * The invariant for this code is that as long as the stack is not empty after processing the input string, there
 * are unmatched characters, which means the string doesn't have an equal number of 'a's and 'b's.
 */
