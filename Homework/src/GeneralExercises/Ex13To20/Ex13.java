package GeneralExercises.Ex13To20;
import java.util.Scanner;
import java.util.Stack;
public class Ex13 {

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (int i =0; i< str.length(); i ++){
            stack.push(charArr[i]);
        }
        for (int i =0; i< str.length(); i ++){
            charArr[i] = stack.pop();
        }
        return String.valueOf(charArr);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
    }
}
