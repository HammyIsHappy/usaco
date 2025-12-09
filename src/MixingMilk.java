import java.util.*;
import java.io.*;

public class MixingMilk {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter("mixmilk.out");

        int[] capacity = new int[3];
        int[] current = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
            current[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 0; i < 100; i++) {
            int bucketToPoor = i % 3;
            if (bucketToPoor == 0) {
                int possible = Math.min(capacity[1] - current[1], current[0]);
                current[0] -= possible;
                current[1] += possible;
            }
            else if (bucketToPoor == 1) {
                int possible = Math.min(capacity[2] - current[2], current[1]);
                current[1] -= possible;
                current[2] += possible;
            }
            else if (bucketToPoor == 2) {
                int possible = Math.min(capacity[0] - current[0], current[2]);
                current[2] -= possible;
                current[0] += possible;
            }
        }
        for (int i = 0; i < 3; i++) {
            pw.println(current[i]);
        }
        pw.close();
    }
}
