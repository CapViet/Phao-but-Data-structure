import java.io.*;
import java.util.*;

public class CountPairSum {



    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int m=Integer.parseInt(a1[0]);
            int n=Integer.parseInt(a1[1]);
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            int a[]=new int[m];
            for(int i=0;i<m;i++)
            {
                a[i]=Integer.parseInt(a2[i]);
            }
            String line3 = br.readLine();
            String[] a3 = line3.trim().split("\\s+");
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                b[i]=Integer.parseInt(a3[i]);
            }
            int x=Integer.parseInt(br.readLine());

            int ans=countPairs(a,b,m,n,x);
            System.out.println(ans);

        }
    }




        // function to count all pairs
        // from both the sorted arrays
        // whose sum is equal to a given
        // value
        static int countPairs(int arr1[],int arr2[], int M, int N, int x)
        {
            //code here.
            //count of sum pair
            int count = 0;
            //add all elements of array 1 into a hash set
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<M;i++){
                set.add(arr1[i]);
            }
            //add all the elements of arr 1 with the elements of arr 2, if it's equals to x, count add 1
            for(int i: set){
                for(int j: arr2){
                    if (i + j == x){
                        count++;
                    }
                }
            }
            return count;

    }

//{ Driver Code Starts.

    // Driver class


// } Driver Code Ends
}
