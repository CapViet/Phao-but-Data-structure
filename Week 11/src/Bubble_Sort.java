import java.util.Scanner;
public class Bubble_Sort {

    public static void bubbleSort (int[] array, int n){

        boolean swapped;
        do{

            swapped = false;
            for (int i = 1; i < n; i++){
                if (array[i-1] > array[i]){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    swapped = true;
                }
            }
            n=n-1;
        }
        while (swapped);
    }
    public static void printArray(int array[], int n)
    {
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void  main(String[] args){
        int[] a = new int[10000];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        bubbleSort(a, n);
        printArray(a, n);
    }
}
