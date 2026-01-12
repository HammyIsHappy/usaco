import java.io.*;
import java.util.*;

public class TheBucketList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter("blist.out");

        int n = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] time = new int[1001];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = cows[i].sTime; j < cows[i].eTime; j++) {
                time[j] += cows[i].bsNeeded;
                max = Math.max(time[j], max);
            }
        }
        pw.println(max);
        pw.close();
        br.close();
    }
}

class Cow {
    int sTime;
    int eTime;
    int bsNeeded;

    public Cow(int s, int e, int b) {
        sTime = s;
        eTime = e;
        bsNeeded = b;
    }
}