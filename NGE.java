/**
 * Given an array, find and print the Next Greater Element (NGE) for each element. 
 * The Next Greater Element for an element 'x' is the first greater element to the 
 * right of 'x' in the array. If no greater element is found, consider it as -1.
 * 
 * Example:
 * Input: arr[] = [ 4 , 5 , 2 , 25 ]
 * Output:  4      –>   5
 *           5      –>   25
 *           2      –>   25
 *          25     –>   -1
 * Explanation: Except 25, every element has an element greater than them present on the right side.
 */

public class NGE {
	public static void printNGE(int arr[], int n) {
		int next, i, j;
		for (i = 0; i < n; i++) {
			next = -1;
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
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
		printNGE(arr, n);
	}
}

/**
 * The invariant in this code snippet is that while traversing an input array from left to right, the stack contains indices of elements that haven't found their next greater element yet.
 */
