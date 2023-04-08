import java.util.PriorityQueue;
import java.util.Scanner;

public class HeightOfHeap {

    public static int heapHeight(int size){
        return (int)Math.ceil(Math.log(size + 1) / Math.log(2) - 1);
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
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the size of the queue: ");
        int size = sc.nextInt();
        for (int i = 0; i < size; i ++){
            int value = sc.nextInt();
            q.add(value);
        }
        print(q);
        System.out.println();
        System.out.println(heapHeight(size));
        sc.close();
    }


}
