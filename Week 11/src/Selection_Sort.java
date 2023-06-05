import java.util.Scanner;
public class Selection_Sort {
    public static void SelectionSort(int[] arr, int n)
    {

        for (int i = 0; i < n-1; i++)
        {

            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;

        }
    }


    public static void printArray(int[] arr, int n)
    {
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[])
    {
        int[] arr = new int[100001];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        SelectionSort(arr, n);
        printArray(arr, n);
    }
}
