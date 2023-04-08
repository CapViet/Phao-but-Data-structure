package GeneralExercises.OtherExercises;
import java.util.Stack;
import java.util.LinkedList;
public class LinkedListPalindromeCheck {
    public static class Node {
      int data;
      Node next;
      Node() {}
      Node(int data) {
        this.data = data;
      }
      Node(int data, Node next) {
          this.data = data;
          this.next = next;
      }
  }
    public static boolean isPalindrome(Node head) {
        //get a copy of the list, ig
        Node temp = head;
        boolean ispalin = true;
        //Using a stack check the palindrome
        Stack<Integer> stack = new Stack<Integer>();

        //basically, copy the temporary list in reverse to the stack, cause stacks do that
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        //time to check the actual list
        while (head != null) {
            //save the value from the top of the stack, which is in the last node of the list
            int i = stack.pop();
            //if the values is equal, continue til the end
            if (head.data == i) {
                ispalin = true;
            }
            //if not, end the loop and return the result
            else {
                ispalin = false;
                break;
            }
            //switch to the next node to check
            head = head.next;
        }
        return ispalin;
    }
    public static void main(String[] args){
        Node one = new Node(1);
        Node two = new Node(2);
        Node drei = new Node(3);
        Node vier = new Node(2);
        Node funf = new Node(1);
        one.next = two;
        two.next = drei;
        drei.next = vier;
        vier.next = funf;
        System.out.println("Is the list a palindrome ? " + isPalindrome(one));
    }
}
