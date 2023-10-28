/**
 * Given a sequence of n strings, the task is to check if any two similar words
 * come together and then destroy each other, then print the number of words
 * left in the sequence after this pairwise destruction.
 *
 * Examples:
 *
 * Input: ab aa aa bcd ab
 * Output: 3
 * As aa, aa destroys each other so,
 * ab bcd ab is the new sequence.
 *
 * Input: tom jerry jerry tom
 * Output: 0
 * As first both jerry will destroy each other.
 * Then the sequence will be tom, tom; they will also destroy
 * each other. So, the final sequence doesn't contain any word.
 */

public class KaPow {
  public static int kaPow(String str) {
    QueueObj queue = new QueueObj(str.length());
    String[] words = str.split(" ");

    for (String word : words) {
      queue.enqueue(word);
    }

    int n = queue.size();
    int initialSize = n;

    for (int i = 0; i < initialSize; i++) {
      String current = (String) queue.dequeue();

      if (queue.isEmpty()) {
        queue.enqueue(current);
        continue;
      }

      String next = (String) queue.peek();

      if (!current.equals(next))
        queue.enqueue(next);
      else {
        queue.dequeue(); // Destroy both words
        n -= 2;
      }
    }
    return n;
  }

  public static void main(String[] args) {
    String sequence1 = "ab aa aa bcd ab";
    String sequence2 = "tom jerry jerry tom";

    int result1 = kaPow(sequence1);
    int result2 = kaPow(sequence2);

    System.out.println("Remaining words in sequence 1: " + result1);
    System.out.println("Remaining words in sequence 2: " + result2);
}
}
