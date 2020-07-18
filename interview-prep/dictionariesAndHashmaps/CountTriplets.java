package dictionariesAndHashmaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r){
        Map<Long,Long> v2 = new HashMap<>();
        Map<Long,Long> v3 = new HashMap<>();
        Long count = 0L;
        for (Long k:arr) {
            count+=v3.get(k)==null?0:v3.get(k);
            if (v2.get(k)!=null) v3.compute(k*r,(key,value)->value!=null?value+v2.get(k):v2.get(k));
            v2.compute(k*r,(key,value)->value==null?1:value+1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
