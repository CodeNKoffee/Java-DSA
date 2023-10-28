/**
 * Given a non-negative integer represented as a string `num` and an integer `k`,
 * this code removes `k` digits from `num` to create the smallest possible integer.
 * The result is obtained by following specific rules, and the code ensures that
 * leading zeros are removed from the final result.
 *
 * Example:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219, which is the smallest.
 *
 * Constraints:
 * - 1 <= k <= num.length <= 105
 * - `num` consists of only digits.
 * - `num` does not have any leading zeros except for the zero itself.
 */


public class RemoveKDigits {
  public String removeKdigits(String num, int k) {
    ArrayStack stack = new ArrayStack(num.length());
    for (char digit : num.toCharArray()) {
      while (!stack.isEmpty() && k > 0 && digit < stack.top()) {
        stack.pop();
        k--;
      }
      stack.push(digit);
    }

    // Remove any remaining k digits from the end
    while (k > 0 && !stack.isEmpty()) {
      stack.pop();
      k--;
      stack.printStack();
    }

    // Build the result string
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    result.reverse();

    // Remove leading zeros
    int i = 0;
    while (i < result.length() - 1 && result.charAt(i) == '0') {
      i++;
    }
    return result.substring(i).isEmpty() ? "0" : result.substring(i);
  }

  public static void main(String[] args) {
    RemoveKDigits solution = new RemoveKDigits(); // Create an instance
    // String num = "1432219";
    String num = "10200";
    // String num = "10";
    // int k = 3;
    int k = 1;
    // int k = 2;
    System.out.print(solution.removeKdigits(num, k));
  }
}

/**
 * The code maintains the invariant that the 'stack' contains a sequence of digits,
 * representing a valid intermediate result with the most significant digits on the left.
 * It continuously removes digits from 'num' to ensure the smallest possible integer
 * is constructed, avoiding leading zeros.
 */
