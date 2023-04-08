package GeneralExercises.OtherExercises;
import java.util.Stack;
public class MaximumNestings {
    public static int maxDepth(String s) {
        int count=0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                st.push(i);//pushing the bracket in the stack
            else if(s.charAt(i) == ')')
            {
                if(count < st.size())
                    count = st.size();
              /*keeping track of the parenthesis and storing it before removing
              it when it gets balanced*/
                st.pop();
            }
        }
        return count;
    }
    public static void main(String[] args){
        String str = "(((x+2)*(x-2) + y) + ass)";
        System.out.println(maxDepth(str));
    }
}
