import java.io.*;
import java.util.*;
public class findSubArraySum0 {
    //{ Driver Code Starts
//Initial Template for Java

    /*package whatever //do not write package name here */



        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            sc.nextLine();
            while(t-->0)
            {
                int n;
                n=sc.nextInt();

                long arr[]=new long[n];


                for(int i=0;i<n;i++)
                {
                    arr[i]=sc.nextLong();
                }

                System.out.println(findSubarray(arr,n));
            }

    }

// } Driver Code Ends


//User function Template for Java


        //Function to count subarrays with sum equal to 0.
        public static long findSubarray(long[] arr ,int n)
        {
            //Your code here
            HashMap<Long,Integer> map=new HashMap<>();
            map.put(0L,1);

            int ans=0;
            long sum=0;

            for(int i=0; i<arr.length; i++){
                sum+=arr[i];
                if(map.containsKey(sum)){
                    ans+=map.get(sum);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return ans;
        }
    }

