import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] ar = new int[n];
        int pairs = 0;
        
        for (int i = 0; i < n; i++) {
            ar[i] = scan.nextInt();
        }
        
        Arrays.sort(ar);
        
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            
            while (j < n) {
                int diff = ar[j] - ar[i];
                if (diff == k) {
                    pairs++;
                    break;
                } else if (diff > k) {
                    break;
                }
                j++;
            }
            
        }
        
        System.out.println(pairs);
    }
}