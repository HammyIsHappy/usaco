import java.io.*;
import java.util.*;

class Pair {
    private int a;
    private int b;

    public int getFirst() {
        return a;
    }

    public int getSecond() {
        return b;
    }

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class CowGymnastics {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("gymnastics.out");

        int sessionCount = Integer.parseInt(st.nextToken());
        int cowCount = Integer.parseInt(st.nextToken());

        int[][] preformances = new int[sessionCount][cowCount];
        for (int i = 0; i < sessionCount; i++) {
            StringTokenizer stLoop = new StringTokenizer(br.readLine());
            for (int j = 0; j < cowCount; j++) {
                preformances[i][j] = Integer.parseInt(stLoop.nextToken());
            }
        }
        br.close();

        ArrayList<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < cowCount - 1; i++) {
            for (int j = i + 1; j < cowCount; j++) {
                pairs.add(new Pair(preformances[0][i], preformances[0][j]));
            }
        }

        int count = 0;
        for (int i = 0; i < pairs.size(); i++) {
            Pair current = pairs.get(i);
            boolean stillValid = true;
            for (int row = 0; row < sessionCount; row++) {
                boolean seenFirst = false;
                boolean seenSecond = false;
                for (int col = 0; col < cowCount; col++) {
                    if (current.getFirst() == preformances[row][col]) {seenFirst = true;}
                    if (current.getSecond() == preformances[row][col]) {seenSecond = true;}
                    if (seenSecond == true && seenFirst == false) {stillValid = false; break;}
                }
                if (!stillValid) {break;}
            }
            if (stillValid) {count++;}
        }
        pw.println(count);
        pw.close();
    }
}
