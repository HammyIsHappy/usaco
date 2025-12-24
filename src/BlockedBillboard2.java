import java.util.*;
import java.io.*;
import java.io.PrintWriter;

public class BlockedBillboard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter("billboard.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[][] view = new boolean[2000][2000];
        int xLowLeft = Integer.parseInt(st.nextToken()) + 1000;
        int yLowLeft = Integer.parseInt(st.nextToken()) + 1000;
        int xHighRight = Integer.parseInt(st.nextToken()) + 1000;
        int yHighRight = Integer.parseInt(st.nextToken()) + 1000;

        for (int i = xLowLeft; i < xHighRight; i++) {
            for (int j = yLowLeft; j < yHighRight; j++) {
                view[i][j] = true;
            }
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int xLowLeft2 = Integer.parseInt(st2.nextToken()) + 1000;
        int yLowLeft2 = Integer.parseInt(st2.nextToken()) + 1000;
        int xHighRight2 = Integer.parseInt(st2.nextToken()) + 1000;
        int yHighRight2 = Integer.parseInt(st2.nextToken()) + 1000;
        for (int i = xLowLeft2; i < xHighRight2; i++) {
            for (int j = yLowLeft2; j < yHighRight2; j++) {
                view[i][j] = false;
            }
        }

        int biggestLength = -1;
        int biggestHeight = -1;

        int yStart = -1;
        int yEnd = -1;
        for (int i = 0; i < 2000; i++) {
            int currentXStart = -1;
            int currentXEnd = -1;
            for (int j = 0; j < 2000; j++) {
                if (view[i][j] == true && yStart == -1) {
                    yStart = i;
                    yEnd = i;
                }
                if (view[i][j] == true && currentXStart == -1) {
                    currentXStart = j;
                }
                if (view[i][j] == true) {
                    currentXEnd = Math.max(currentXEnd, j);
                    yEnd = Math.max(yEnd, i);
                }
                biggestLength = Math.max(biggestLength, currentXEnd - currentXStart);
                biggestHeight = Math.max(biggestHeight, yEnd - yStart);
            }
        }
        if (biggestHeight == 0 && biggestLength == 0) {
            pw.println(0);
        }
        else {
            pw.println((biggestHeight + 1) * (biggestLength + 1));
        }
        pw.close();
        br.close();
    }
}
