/**
 * Given an array, find and print the Next Smaller Element (NSE) for each element. 
 * The Next Smaller Element for an element 'x' is the first smaller element to the 
 * right of 'x' in the array. If no smaller element is found, consider it as -1.
 * 
 * Example:
 * Input: arr[] = [ 11, 13, 21, 3 ]
 * Output:  11      –>   3
 *           13      –>   3
 *           21      –>   3
 *           3      –>   -1
 * Explanation: Except 3, every element has an element smaller than them present on the right side.
 */

public class NSE {
  public static void printNSE(int arr[], int n) {
    int next, i, j;
    for (i = 0; i < n; i++) {
      next = -1;
      for (j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          next = arr[j];
          break;
        }
      }
      System.out.println(arr[i] + " --> " + next);
    }
  }

  public static void main(String args[]) {
    int arr[] = { 11, 13, 21, 3 };
    int n = arr.length;
    printNSE(arr, n);
  }
}
/**
 * The invariant in this code snippet is that while traversing an input array from left to right, the stack contains indices of elements that haven't found their next smaller element yet.
 */
