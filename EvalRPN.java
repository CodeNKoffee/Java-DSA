/*
You are given an array of strings tokens that represents an arithmetic expression in Reverse Polish Notation (RPN).

Evaluate the expression and return an integer that represents the value of the expression.

Notes:
- Valid operators are '+', '-', '*', and '/'.
- Each operand may be an integer or another expression.
- The division between two integers truncates toward zero.
- There will not be any division by zero.
- The input represents a valid arithmetic expression in RPN.
- The answer and all intermediate calculations can be represented as 32-bit integers.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Constraints:
1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
*/


public class EvalRPN {
  public static int evalRPN(String[] tokens) {
    ArrayStack stack = new ArrayStack(tokens.length);
    int operand2 = 0;
    int operand1 = 0;
    for (String token : tokens) {
      switch (token) {
        case "/":
          operand2 = stack.pop();
          operand1 = stack.pop();
          stack.push(operand1 / operand2);
          break;
        case "*":
          operand2 = stack.pop();
          operand1 = stack.pop();
          stack.push(operand1 * operand2);
          break;
        case "+":
          operand2 = stack.pop();
          operand1 = stack.pop();
          stack.push(operand1 + operand2);
          break;
        case "-":
          operand2 = stack.pop();
          operand1 = stack.pop();
          stack.push(operand1 - operand2);
          break;
        default:
          stack.push(Integer.parseInt(token));
          break;
        }
      }
    return stack.pop();
  }

  public static void main(String[] args) {
    // String[] tokens = {"2","1","+","3","*"};
    // String[] tokens = {"4","13","5","/","+"};
    String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    System.out.println(evalRPN(tokens));
  }
}

/*
  The invariant is that the stack always contains the correct set of operands and intermediate results necessary to compute the final result of the RPN expression. It maintains the order and structure of the expression as you evaluate it.
 */


