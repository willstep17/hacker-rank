package arrays;

public class NewYearChaos {
    public static void minimumBribes(int[] q) {

        for(int i=0;i<q.length;i++){
            if((q[i] - (i+1)) > 2){
                System.out.println("Too chaotic");
                return;
            }
        }

        int temp, swaps = 0;
        for(int i = 0;i< q.length;i++){
            for(int j = i+1;j<q.length;j++){
                if(q[i] > q[j]){
                    temp = q[j];
                    q[j] = q[i];
                    q[i] = temp;
                    swaps++;
                }
            }
        }

        System.out.println(swaps);
    }

}
