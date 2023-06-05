public class Sorting_Usage {
    public static void ascending (int[] array){
        int n = array.length;
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

    public static void descending(int[] array){
        int n = array.length;
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

    public static void printArray(int array[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void main(String[] args){

            int n = 6;
            int k = 4;
            int arr[] = {91, 451 , 43, 3, 452, 54};
            System.out.println("The initial array: ");
            printArray(arr);

            System.out.println("Ascending order");
            ascending(arr);
            printArray(arr);
            System.out.println("The " + k +  "th smallest element: " + arr[k -1]);

            System.out.println("Descending order");
            descending(arr);
            printArray(arr);
            System.out.println("The " + k +  "th largest element: " + arr[k - 1]);
    }
}
