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
