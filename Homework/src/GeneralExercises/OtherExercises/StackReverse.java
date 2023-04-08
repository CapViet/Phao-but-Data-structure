package GeneralExercises.OtherExercises;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class StackReverse {
    public static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        Queue<Integer> temp = new LinkedList<Integer>();
        //since queue and stack is the reverse of each other
        //use a temporary queue to save the elements of the original stack
        while(!s.isEmpty())
            temp.add(s.pop());
        //when remove an element from a queue, it's the first element added
        //when you push that element in a stack, it becomes the bottom element, thus reversing the stack
        while(!temp.isEmpty())
            s.push(temp.remove());
        // add your code here
    }
    public static void print(Stack<Integer> s){
        if (s.empty())
            return;
        // Extract top of the stack
        int x = s.peek();

        // Pop the top element
        s.pop();

        // Print the current top
        // of the stack i.e., x
        System.out.print(x + " ");

        // Proceed to print
        // remaining stack
        print(s);

        // Push the element back
        s.push(x);
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(12);
        print(stack);

        System.out.println();
        reverse(stack);
        print(stack);
    }
}
