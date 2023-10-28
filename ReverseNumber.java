/**
 * Given a number, this program reverses the number using a stack.
 *
 * Examples:
 *
 * Input: 365
 * Output: 563
 *
 * Input: 6899
 * Output: 9986
 *
 * The idea is to extract the digits of the number and push them onto a stack.
 * Once all the digits are pushed onto the stack, we pop the contents of the stack
 * one by one to form the reversed number. As a stack is a Last-In-First-Out (LIFO)
 * data structure, the digits of the newly formed number will be in reverse order.
 */

public class ReverseNumber {
  public static int reverseNumber(int num) {
    if (num == 0) {
      return 0;
    }
    else {
      int numCopy = num;
      int size = 0;
      while (numCopy != 0) {
        numCopy /= 10;
        size++;
      }
  
      ArrayStack stack = new ArrayStack(size);
      boolean isNegative = false;
  
      if (num < 0) {
        isNegative = !isNegative;
        num *= -1;
      }
  
      while (num != 0) {
        stack.push(num % 10);
        num /= 10;
      }
  
      StringBuilder reversedNum = new StringBuilder();
      while (!stack.isEmpty()) 
        // Insert at the beginning
        reversedNum.insert(0, stack.pop()); 
  
      int reversedValue = Integer.parseInt(reversedNum.toString());
  
      return isNegative ? -reversedValue : reversedValue;
    }
  }

  public static void main(String[] args) {
    // Test the reverseNumber method with different inputs
    int num1 = 12345;
    int num2 = -6789;
    int num3 = 0;

    int reversed1 = reverseNumber(num1);
    int reversed2 = reverseNumber(num2);
    int reversed3 = reverseNumber(num3);

    System.out.println("Original number: " + num1 + ", Reversed: " + reversed1);
    System.out.println("Original number: " + num2 + ", Reversed: " + reversed2);
    System.out.println("Original number: " + num3 + ", Reversed: " + reversed3);
  }
}

/**
 * Push digits onto the stack and build the reversed number.
 * Stack's LIFO property ensures digits are reversed in order.
 */


