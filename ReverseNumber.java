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

