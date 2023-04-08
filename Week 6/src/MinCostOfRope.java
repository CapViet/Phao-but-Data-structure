import java.security.PrivilegedAction;
import java.util.PriorityQueue;
public class MinCostOfRope {

    public static long minCost(long arr[], int size)
    {
        long cost = 0;
        //use the priority queue, cause it's sorted from smallest to biggest
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<size;i++)
        {
            pq.add(arr[i]);
        }
        System.out.println("Priority queue: ");
        print(pq);
        System.out.println();
        System.out.println("Operation: ");
        //everytime an element gets removed/added, the priority queue updates itself so the order stays the same
        while(pq.size()>1)
        {
            //extracting the two top elements, aka the two smallest ones
            long val1 = pq.remove();
            long val2 = pq.remove();

            long val = val1 + val2;

            cost = cost + val;
            pq.add(val);
            print(pq);
            System.out.println();
        }
        return cost;
    }
    public static void print(PriorityQueue<Long> s){
        if (s.isEmpty())
            return;
        long x = s.peek();
        s.poll();
        System.out.print(x + " ");
        print(s);
        s.add(x);
    }
    public static void print(long[] arr){
        System.out.println("Array :");
        for (long l : arr) {
            System.out.print(l + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        long[] arr = new long[5];
        arr[0] = 4;
        arr[1] = 2;
        arr[2] = 7;
        arr[3] = 6;
        arr[4] = 9;
        int size = arr.length;
        print(arr);
        System.out.println("cost = " + minCost(arr, size));
    }
}
