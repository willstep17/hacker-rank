import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InfiniteStrings {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long asInString = 0;
        long finalAs = 0;
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if (c == 'a') {
                asInString++;
            }
        }
        long fullStrings = n / s.length();
        finalAs = asInString * fullStrings;
        long remainderChars = n % s.length();
        for(int i=0;i<remainderChars;i++) {
            if(chars[i] == 'a') {
                finalAs++;
            }
        }
        return finalAs
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}