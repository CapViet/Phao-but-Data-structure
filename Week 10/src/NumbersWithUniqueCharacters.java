import java.io.*;
import java.util.*;

public class NumbersWithUniqueCharacters {
    //{ Driver Code Starts
//Initial Template for Java


        public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0)
            {


                int l=sc.nextInt();
                int r=sc.nextInt();

                ArrayList<Integer> numbers = uniqueNumbers(l,r);
                for(int num : numbers){
                    System.out.print(num+" ");
                }
                System.out.println();

            }
        }

// } Driver Code Ends


        static ArrayList<Integer> uniqueNumbers(int L,int R){
            // code here
            ArrayList<Integer> al = new ArrayList<>();
            for (int i=L;i<=R;i++){
                if (isValid(i)){
                    al.add(i);
                }
            }
            return al;
        }

        //method to pick the numbers with unique characters
        public static boolean isValid(int num) {
            Set<Integer> hs = new HashSet<>();
            while (num > 0) {
                //take the last character of the number
                int p = num % 10;
                //for the next loop (after the first one), if the hashmap already have that character, it's invalid
                if (hs.contains(p)) {
                    return false;
                }
                //add the character to the hashset, if it's alr not in it, since a number can have different character
                hs.add(p);
                //start the next loop with the remaining characters
                num /= 10;
            }
            return true;
        }

}
