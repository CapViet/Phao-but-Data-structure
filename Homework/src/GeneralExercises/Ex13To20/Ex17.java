package GeneralExercises.Ex13To20;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Ex17{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<Integer>();
        int temp, n, k;
        n = sc.nextInt();
        for (int i = 0; i < n; i++){
            temp = sc.nextInt();
            q.add(temp);
        }
        k = sc.nextInt();
        for (int i = 0; i < k; i++){
            int x = q.peek();
            q.poll();
            q.add(x);
        }
        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.poll();
        }
        sc.close();
    }
}
