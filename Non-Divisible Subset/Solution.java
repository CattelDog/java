import java.io.*;
import java.util.*;

public class Solution {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int divisor = scan.nextInt();
        LinkedList<Integer>[] theList = new LinkedList[divisor];
        int[] arr = new int[size];
        int temp = 0;
        int listSizeA = 0;
        int listSizeB = 0;
        int maxSize = 0;
        
        for (int i = 0; i < divisor; i++) {
            theList[i] = new LinkedList<Integer>();
        }
        
        for (int i = 0; i < size; i++) {
            temp = scan.nextInt();
            theList[temp % divisor].push(temp);
            
        }
        
        for (int a = 1; a < (divisor/2 + divisor%2); a++) {
            listSizeA = theList[a].size();
            listSizeB = theList[divisor - a].size();
            
            if (listSizeA > listSizeB) {
                maxSize += listSizeA;
            } else {
                maxSize += listSizeB;
            }
                      
        }
        
       if (theList[0].size() > 0) {
           maxSize += 1;
       } 
     
       if (divisor%2 == 0) {
           if (theList[divisor/2].size() > 0) {
               maxSize +=1;
           }
       }
       
        System.out.println(maxSize);  
        
    }
}