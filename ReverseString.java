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