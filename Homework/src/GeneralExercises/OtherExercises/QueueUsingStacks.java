package GeneralExercises.OtherExercises;
import java.util.Stack;
public class QueueUsingStacks {
    class StackQueue
    {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        //Function to push an element in queue by using 2 stacks.
        void Push(int x)
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
                //s1.pop();
            }

            // Push item into s1
            s1.push(x);

            // Push everything back to s1
            while (!s2.isEmpty())
            {
                s1.push(s2.pop());
                //s2.pop();
            }
            // Your code here
        }


        //Function to pop an element from queue by using 2 stacks.
        int Pop()
        {
            // if first stack is empty
            if (s1.isEmpty())
            {
                System.out.println("Q is Empty");
                System.exit(0);
            }

            // Return top of s1
            int x = s1.peek();
            s1.pop();
            return x;
            // Your code here
        }
    }

}
