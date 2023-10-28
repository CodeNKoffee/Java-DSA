/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * @param n The number of pairs of parentheses.
 * @return An array of well-formed parentheses combinations.
 */

public class GenerateParentheses {
  public String[] generateParenthesis(int n) {
    if (n <= 0) {
      return new String[0];
    }

    int maxCombinations = (int) Math.pow(2, 2 * n);
    String[] result = new String[maxCombinations];
    int index = 0;
    char[] current = new char[2 * n];

    generateParenthesisRecursive(n, n, 0, current, result, index);

    return result;
  }

  private void generateParenthesisRecursive(int left, int right, int index, char[] current, String[] result, int resultIndex) {
    if (left == 0 && right == 0) {
      result[resultIndex] = new String(current);
      resultIndex++;
      return;
    }

    if (left > 0) {
      current[index] = '(';
      generateParenthesisRecursive(left - 1, right, index + 1, current, result, resultIndex);
    }

    if (right > left) {
      current[index] = ')';
      generateParenthesisRecursive(left, right - 1, index + 1, current, result, resultIndex);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses generator = new GenerateParentheses();
    int n = 3;
    String[] combinations = generator.generateParenthesis(n);

    for (String combination : combinations) {
      System.out.println(combination);
    }
  }
}

/**
 * Invariant: The `generateParenthesisRecursive` function explores all possible combinations of well-formed parentheses
 * with `left` representing the number of remaining open parentheses and `right` representing the number of remaining
 * close parentheses. As the recursion proceeds, it ensures that we add an open parenthesis `(` if there are remaining
 * open parentheses, and it adds a close parenthesis `)` only if there are more open parentheses than close parentheses.
 *
 * @param args Command-line arguments.
 */
