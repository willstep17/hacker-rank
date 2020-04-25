package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Hourglass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int largestHourglass = Integer.MIN_VALUE;
        int currentHourglass = 0;
        for(int x=1;x<5;x++) {
            for(int y=1;y<5;y++) {
                currentHourglass = calculateHourglass(arr, x, y);
                if(currentHourglass > largestHourglass) {
                    largestHourglass = currentHourglass;
                }
            }
        }
        return largestHourglass;
    }

    private static int calculateHourglass(int[][] arr, int x, int y) {
        int returnSum = 0;
        returnSum += arr[x][y];
        for(int i=-1;i<2;i++) {
            returnSum += arr[x+1][y+i];
        }
        for(int i=-1;i<2;i++) {
            returnSum += arr[x-1][y+i];
        }
        return returnSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}