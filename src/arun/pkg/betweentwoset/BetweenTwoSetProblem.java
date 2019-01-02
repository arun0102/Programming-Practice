package arun.pkg.betweentwoset;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class BetweenTwoSetProblem {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        int minB = Integer.MAX_VALUE;
        for(int i=0; i<b.length; i++) {
            if(minB > b[i]) {
                minB = b[i];
            }
        }
        
        ArrayList<Integer> divArr = new ArrayList<Integer>();
        for(int i=1; i<=minB; i++) {
            boolean isDividing = true;
            for(int j=0; j<b.length; j++) {
                if(b[j]%i != 0) {
                    isDividing = false;
                    break;
                }
            }
            if(isDividing) {
                divArr.add(i);
            }
        }
        
        ArrayList<Integer> commonArr = new ArrayList<Integer>();
        for(int i=0; i<divArr.size(); i++) {
        	boolean isDividing = true;
            for(int j=0; j<a.length; j++) {
                if(divArr.get(i)%a[j] != 0) {
                	isDividing = false;
                	break;
                }
            }
            if(isDividing) {
            	commonArr.add(divArr.get(i));
            }
        }
        return commonArr.size();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] a = {2, 4};
        
        int[] b = {16, 32, 96};
    	
        int total = getTotalX(a, b);

        System.out.println(total);
    }
}

