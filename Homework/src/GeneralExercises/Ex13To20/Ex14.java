package GeneralExercises.Ex13To20;

import java.util.Scanner;
import java.util.Stack;
public class Ex14 {

    public static void binary(int dec){
        Stack<Integer> stack = new Stack<>();
        while(dec > 0){
            stack.push(dec%2);
            dec/=2;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int decimal = sc.nextInt();
        binary(decimal);
    }
}
