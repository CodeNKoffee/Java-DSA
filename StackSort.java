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