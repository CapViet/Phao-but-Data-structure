import java.util.Arrays;
import java.util.Scanner;

public class SumBetween2RandomElements {
    public static long sumBetweenTwoKth(long a[], int n, int k1, int k2)
    {
        // Your code goes here
        Arrays.sort(a);
        long sum =0L;
        for(int i=0;i<n;i++){
            if(i>=k1 && i<k2-1){
                sum = sum+a[i];
            }
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of the array: 9");
        int size = 9;
        long[] arr = new long[size];
        System.out.println("Enter the array");
        for (int i = 0; i < size; i ++){
            long value = sc.nextLong();
            arr[i] = value;
        }
        System.out.println(sumBetweenTwoKth(arr, size, 2, 8));
    }
}
