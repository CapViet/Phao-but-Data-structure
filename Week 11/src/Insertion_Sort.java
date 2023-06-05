import java.util.Scanner;
public class Insertion_Sort {
    public static void insertionSort(int[] array, int n){
        for (int i = 1; i < n; ++i) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
    }
    public static void printArray(int array[], int n)
    {
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void  main(String[] args){
        int[] array = new int[100001];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        insertionSort(array, n);
        printArray(array, n);
    }
}
