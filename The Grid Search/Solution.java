import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            boolean theyMatch = false;
            int i = 0;
            while (i < (R - r + 1)) {
                int ndx = G[i].indexOf(P[0]);
                
                if (ndx > -1) {
                    int p_row = 1;
                    
                    boolean match = true;
                    while (p_row < r) {
                        if (G[i+p_row].indexOf(P[p_row]) == ndx) {
                            p_row++;
                        } else {
                            match = false;
                            p_row = r;
                        }
                    }
                    if (match) {
                        theyMatch = match;
                    } else {
                        //Any more?
                        while (ndx != G[i].lastIndexOf(P[0])) {
                            match = true;
                            ndx = G[i].indexOf(P[0], (1 + ndx));
                            p_row = 1;
                            
                            while (p_row < r) {
                                if (G[i + p_row].indexOf(P[p_row], ndx) == ndx) {
                                    p_row++;
                                } else {
                                    match = false;
                                    p_row = r;
                                }
                            }
                            
                            if (match) {
                                theyMatch = match;
                            }

                        }
                    }
                }
                i++;
            }
            
            if (theyMatch) {
                System.out.println("YES"); 
            } else {
                System.out.println("NO");
            }
        }
    }
}
