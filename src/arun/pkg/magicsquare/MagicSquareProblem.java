package arun.pkg.magicsquare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MagicSquareProblem {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][][] possibleArr = {
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{2, 9, 4}, {7, 5, 3}, {8, 1, 6}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}
            };
            
            int minDiff = Integer.MAX_VALUE;
            for(int i=0; i<8; i++) {
                int diff = 0;
                int[][] arr = possibleArr[i];
                for(int j=0; j<3; j++) {
                    for(int k=0; k<3; k++) {
                        diff += Math.abs(s[j][k] - arr[j][k]);
                    }
                }
                if(minDiff > diff) {
                    minDiff = diff;
                }
            }
        
        return minDiff;
    }

    public static void main(String[] args) throws IOException {
        
        int[][] s = {{4, 1, 5}, {7, 6, 4}, {7, 2, 2}};

        int result = formingMagicSquare(s);

        System.out.println(result);
    }
}
