import java.util.*;
import java.io.*;

public class SleepyCowSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter pw = new PrintWriter("sleepy.out");
        int cowCount = Integer.parseInt(br.readLine());

        int[] cows = new int[cowCount];
        boolean[] wrong = new boolean[cowCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cowCount; i++) {
            cows[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int biggestOutOfPlace = -1;
        for (int i = 0; i < cows.length - 1; i++) {
            if (cows[i] > cows[i + 1]) {
                wrong[i] = true;
            }
        }

        for (int i = 0; i < wrong.length; i++) {
            if (wrong[i] == true) {
                biggestOutOfPlace = i;
            }
        }
        
        pw.println(biggestOutOfPlace + 1);
        pw.close();
        br.close();
    }
}
