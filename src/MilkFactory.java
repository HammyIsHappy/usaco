import java.io.*;
import java.util.*;

class Pair {
    private int a;
    private int b;
    
    public Pair(int ax, int bx) {
        a = ax;
        b = bx;
    }

    public int to() {
        return b;
    }

    public int from() {
        return a;
    }

    public String toString() {
        return "[" + a + "," + b + "]";
    }
}

public class MilkFactory {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("factory.out");

        int stationCount = Integer.parseInt(st.nextToken());

        Pair[] paths = new Pair[stationCount - 1];
        for (int i = 0; i < stationCount - 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            paths[i] = new Pair(Integer.parseInt(st1.nextToken()) - 1, Integer.parseInt(st1.nextToken()) - 1);
        }
        br.close();


        boolean[] canReachFromAll = new boolean[stationCount];
        //System.out.println(canReachI(0, paths, 0, 1));
        for (int i = 0; i < stationCount; i++) {
            for (int j = 0; j < stationCount; j++) {
                canReachFromAll[i] = canReachI(0, paths, j, i);
                if (canReachFromAll[i] == false) {break;}
            }
        }
        boolean printed = false;
        for (int i = 0; i < stationCount; i++) {
            if (canReachFromAll[i] == true) {
                pw.println(i + 1);
                printed = true;
                break;
            }
        }
        if (!printed) {pw.println(-1);}
        pw.close();
    }

    public static boolean canReachI(int hops, Pair[] paths, int currentLocation, int target) {
        if (currentLocation == target) {
            return true;
        }
        if (hops > paths.length) {
            return false;
        }
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].from() == currentLocation) {
                return canReachI(hops + 1, paths, paths[i].to(), target);
            }
        }
        return false;
    }
}
