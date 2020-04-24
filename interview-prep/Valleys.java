
public class Valleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        char[] steps = s.toCharArray();
        int altitude = 0, valleys = 0;
        boolean below = false;
        for(char step : steps) {
            if(step == 'D') {
                altitude --;
            } else {
                altitude ++;
            }
            if(!below && altitude == -1) {
                valleys ++;
                below = true;
            }
            if(below && altitude == 0) {
                below = false;
            }
        }
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}