package GeneralExercises.OtherExercises;
import java.util.Stack;
public class DeleteMid {

    //delete mid, as in the literal middle element. Ex if there are 5 elements, delete the 3rd one
    //if there are 4, delete the second one
    public static void deleteMid(Stack<Integer>s,int sizeOfStack){
        //for recursive, if after a number of pops, we reached the middle element
        int popped_elements = sizeOfStack -  s.size();
        //if we have reached it, pop the middle element, don't push anything back and end the method
        if(popped_elements == sizeOfStack/2){
            s.pop();
            return;
        }
        //save the top element
        int x = s.peek();
        //pop the top element
        s.pop();
        //recursive to continue popping
        deleteMid(s, sizeOfStack);
        //push the popped element back, in this case it's not the middle element, so we put it back
        s.push(x);
    }
    public static void print(Stack<Integer> s){
        //for the recursive process, if it's empty, end the method
        if (s.empty()) {
            System.out.println();
            return;
        }
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
        Stack<Integer> s = new Stack<>();
        s.push(213);
        s.push(24134);
        s.push(34);
        s.push(88);
        s.push(100);
        int sizeOfStack = s.size();
        print(s);
        deleteMid(s, sizeOfStack);
        print(s);
    }
}
