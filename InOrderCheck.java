//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

class inOrderCheck{
    public static void main(String[] args)throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            System.out.println(Solution.isRepresentingBST(arr, N));

    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {

        // code here
        for(int i = 0; i + 1< N; i ++){
            if(arr[i] >= arr[i+1]){
                return 0;
            }
        }
        return 1;
    }
}
