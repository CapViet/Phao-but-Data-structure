import java.io.*;
import java.util.*;
public class SecondMostRepeatedString {
    //{ Driver Code Starts
//Initial Template for Java



        public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0)
            {
                int n = sc.nextInt();
                String arr[] = new String[n];
                for(int i = 0;i<n;i++)
                    arr[i] = sc.next();

                System.out.println(secFrequent(arr, n));
            }
        }
// } Driver Code Ends


//User function Template for Java


        static String secFrequent(String arr[], int N)
        {
            // your code here
            HashMap<String, Integer> map = new HashMap<>();
            for(String s: arr){
                if(map.containsKey(s)){
                    map.put(s, map.get(s) + 1);
                }
                else {
                    map.put(s, 1);
                }
            }

            //add all the value into an array list
            List<Integer> list =  new ArrayList<>();
            for (String key: map.keySet())
                list.add(map.get(key));

            //sort the list and get the second largest element
            Collections.sort(list);
            int secondLargest = list.get(list.size() - 2);
            //return the key with the second largest value
            for (String key: map.keySet()) {
                if (map.get(key) == secondLargest){
                    return key;
                }
            }
            return null;
        }

}
