package GeneralExercises.Ex13To20;

import java.util.Scanner;
import java.util.Stack;
public class Ex15{
    public static String Encode(String str){
        Stack<Character> stack = new Stack<>();
        String s = "";
        str = str + "@";
        char[] charArr = str.toCharArray();
        for(int i =0; i < str.length(); i++){
            if (stack.isEmpty() || stack.peek() == charArr[i]){
                stack.push(charArr[i]);
            } else {
                int count = 0;
                s = s + stack.peek();
                while(!stack.isEmpty()){
                    count++;
                    stack.pop();
                }
                s = s + Integer.toString(count);
                stack.push(charArr[i]);
            }
        }
        return s;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(Encode(str));

    }
}
