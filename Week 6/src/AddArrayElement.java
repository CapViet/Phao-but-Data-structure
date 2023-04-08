import java.util.PriorityQueue;
import java.util.Scanner;
public class AddArrayElement {
    public static int minOperations(int[] arr, int size, int k, PriorityQueue<Integer> q) {
        int count = 0;

        for (int i : arr) {
            q.offer(i);
        }

        while (size > 1 && q.peek() < k) {
            int sum = q.poll() + q.poll();
            q.offer(sum);
            count++;
        }

        return (q.peek() >= k) ? count : -1;
    }
    public static void print(PriorityQueue<Integer> s){
        if (s.isEmpty())
            return;
        int x = s.peek();
        s.poll();
        System.out.print(x + " ");
        print(s);
        s.add(x);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue();
        System.out.print("Choose the size of the queue: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i ++){
            int value = sc.nextInt();
            arr[0] = value;
            q.add(value);
        }
        print(q);
        System.out.println();
        System.out.print("Select the min of the queue: ");
        int min =  sc.nextInt();
        System.out.println(minOperations(arr, size, min, q));
        print(q);
        sc.close();
    }
}
