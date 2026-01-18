import java.util.*;
import java.io.*;

public class TamingTheHerd {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter("taming.out");
        
        int n = Integer.parseInt(br.readLine());
        int[] counter = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            counter[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i > 0; i--) {
            if (counter[i - 1] == -1 && counter[i] > 0) {
                counter[i - 1] = counter[i] - 1;
            }
        }
        counter[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            if (counter[i] != counter[i + 1] - 1 && counter[i + 1] != -1 && counter[i + 1] != 0) {
                pw.println(-1);
                pw.close();
                return;
            }
        }

        int breakoutsMin = 0;
        int breakoutsMax = 0;
        for (int i = 0; i < n; i++) {
            if (counter[i] == 0) {breakoutsMin++; breakoutsMax++;}
            if (counter[i] < 0) {breakoutsMax++;}
        }
        
        pw.println(breakoutsMin + " " + breakoutsMax);
        pw.close();
        br.close();
    }
}