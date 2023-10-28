/*
Suppose we have a stack of integers. Initially the integers are not sorted. We would like to rearrange the stack using the insertion sort algorithm presented in lectures for arrays. The elements should be in ascending order where the smallest element will be on top of the stack and the largest at the bottom of the stack.

a) Write an external Java method void stackSort(ObjectStack s) that takes a stack of integers s and sorts the stack based on the insertion sort algorithm for arrays. Please note that you are not allowed to use except stacks and the following constructor and methods:
    public ObjectStack(int maxSize)
    public void push(Object o)
    public Object pop()
    public Object top()
    public boolean isEmpty()
    public boolean isFull()
    public int size()
*/


public class StackSort {
  public static StackObj stackSort(StackObj s) {
    if (s.isEmpty() || s.size() == 1)
      return s;
    else {
      StackObj tempStack = new StackObj(s.size());
      while (!s.isEmpty()) {
        Object current = s.pop();
        while (!tempStack.isEmpty() && (int) tempStack.top() > (int) current)
          s.push(tempStack.pop());
        tempStack.push(current);
      }
      while (!tempStack.isEmpty())
        s.push(tempStack.pop());
      return s;
    }
  }

  public static void main(String[] args) {
    StackObj stack = new StackObj(5);
    stack.push(5);
    stack.push(2);
    stack.push(9);
    stack.push(1);
    stack.push(3);

    System.out.println("Original Stack:");
    stack.printStack();

    stackSort(stack);

    System.out.println("Sorted Stack:");
    stack.printStack();
  }
}

/*
b) Given an initially unordered stack
1. What is the best case complexity of the algorithm? Justify your answer.
Solution:
Best Case O(n), because there will be only one element out of place, therefore the loop will execute n times and the inner loop will be executed only once.

2. What is the worst case complexity of the algorithm? Justify your answer.
Solution:
Worst Case O(n^2), because all elements will be out of place, and both nested loops will be executed n times.

3. What is the invariant of the algorithm? Justify your answer.
Solution:
The invariant: After n passes, n elements are partially sorted because in each iteration we insert one of the unsorted elements in its correct position.
*/
