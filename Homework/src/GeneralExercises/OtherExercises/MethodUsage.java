package GeneralExercises.OtherExercises;
import java.util.*;
public class MethodUsage {
    public static Stack<Integer>_push(ArrayList<Integer> arr,int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i =0; i < n; i++){
            st.push(arr.get(i));
        }
        return st;
        //Your code here


    }

    public static void _pop(Stack<Integer>s)
    {
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        //Your code here
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i ++){
            int x = sc.nextInt();
            arr.add(x);
        }

        Stack<Integer> st = _push(arr, n);
        _pop(st);
    }
}
