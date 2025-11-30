import java.util.*;
import java.io.*;

public class SpeedingTicket {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("speeding.out");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> speedLimits = new ArrayList<Integer>(100);
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int miles = Integer.parseInt(tok.nextToken());
            int spdLimit = Integer.parseInt(tok.nextToken());
            for (int j = 0; j < miles; j++) {
                speedLimits.add(spdLimit);
            }
        }

        ArrayList<Integer> speeds = new ArrayList<Integer>(100);
        for (int i = 0; i < m; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int miles = Integer.parseInt(tok.nextToken());
            int spd = Integer.parseInt(tok.nextToken());
            for (int j = 0; j < miles; j++) {
                speeds.add(spd);
            }
        }
        //pw.println(speeds);
        //pw.println(speedLimits);
        br.close();

        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (speeds.get(i) - speedLimits.get(i) > max) {
                max = speeds.get(i) - speedLimits.get(i);
            }
        }
        pw.println(max);
        pw.close();
    }
}
