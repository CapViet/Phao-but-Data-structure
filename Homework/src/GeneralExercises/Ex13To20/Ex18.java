package GeneralExercises.Ex13To20;

import java.util.*;

public class Ex18{
    public static boolean isPrime(int n){
        if (n<2)
            return false;
        for (int i=2; i<= Math.sqrt(n); i++){
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
    public static void  main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i <= n && i < 10; i++){
            if (isPrime(i)){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            for (int i = 1; i <= 9; i++){
                int k = q.peek()*10 + i;
                if ( k <= n && isPrime(k)){
                    q.add(q.peek()*10 + i);
                }
            }
            System.out.print(q.peek() + " ");
            q.poll();
        }
        sc.close();
    }
}
