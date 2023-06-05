import java.util.Scanner;
import java.util.*;

public class MaxDistanceBetweenOccurrences {
    //{ Driver Code Starts


        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t =sc.nextInt();
            while(t>0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for(int i=0;i<n;i++)
                    arr[i] = sc.nextInt();

                System.out.println(maxDistance(arr,n));

                t--;
            }
        }
// } Driver Code Ends


    // your task is to complete this function
    static int maxDistance(int arr[], int n)
        {
            // Your code here
            HashMap<Integer,Integer> map =new HashMap<>();
            int ans=0;
            for(int i=0;i<n;i++){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],i);
                }else if(i>map.get(arr[i])){
                    map.put(arr[i],i);
                }
            }
            for(int i=0;i<n;i++){
                ans=Math.max(ans,map.get(arr[i])-i);
            }
            return ans;
        }

}
