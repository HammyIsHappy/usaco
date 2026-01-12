import java.io.*;
import java.util.*;

public class TheBovineShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter("shuffle.out");

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] swaps = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            swaps[i] = Integer.parseInt(st.nextToken()) - 1;
            cows[i] = Integer.parseInt(st2.nextToken());
        }

        int[] oldCows = new int[n];
        for (int i = 0; i < n; i++) {
            oldCows[i] = cows[swaps[swaps[swaps[i]]]];
        }

        for (int num : oldCows) {
            pw.println(num);
        }
        pw.close();
        br.close();
    }
}
