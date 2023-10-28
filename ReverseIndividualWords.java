/**
 * Given a string, this program reverses the individual words in it.
 *
 * Examples:
 *
 * Input: "Hello World"
 * Output: "olleH dlroW"
 *
 * Input: "Geeks for Geeks"
 * Output: "skeeG rof skeeG"
 *
 * Method 1 (Simple): Generate all words separated by space. One by one reverse words
 * and print them separated by space.
 *
 * Method 2 (Space Efficient): We use a stack to push all words before space. As soon as we
 * encounter a space, we empty the stack.
 */

public class ReverseIndividualWords {
  public static String reverseWords(String str) {
    if (str == null || str.length() < 1)
      return str;
    else {
      StackObj stack = new StackObj(str.length());

      StringBuilder reversedWords = new StringBuilder();

      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
          while (!stack.isEmpty()) 
            reversedWords.append((char) stack.pop());

          reversedWords.append(' ');
        }
        else stack.push(str.charAt(i));
      }

      // Handle the last word
      while (!stack.isEmpty()) 
        reversedWords.append((char) stack.pop());

      return reversedWords.toString();
    }
  }

  public static void main(String[] args) {
    String str = "Hello, World";
    System.out.println(reverseWords(str));
  }
}

/**
 * Push words onto the stack and reverse them individually.
 * Stack's LIFO property maintains word order within the string.
 */
