package stringManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int lA,lB,c=0,e=0;
        lA = a.length();
        lB = b.length();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        for(int i=0;i<lA;i++) {
            for(int j=0;j<lB;j++) {
                if(aChar[i] == bChar[j]){
                    e++;
                    bChar[j] = '#';
                    break;
                }
            }
        }
        return (lA-e)+(lB-e);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}