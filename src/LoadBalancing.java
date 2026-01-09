import java.util.*;
import java.io.*;

public class LoadBalancing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter("balancing.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int gridSize = Integer.parseInt(st.nextToken());

        Cord[] cords = new Cord[count];
        for (int i = 0; i < count; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            cords[i] = new Cord(x, y);
        }

        Set<Integer> xs = new TreeSet<Integer>();
        Set<Integer> ys = new TreeSet<Integer>();

        for (Cord val : cords) {
            xs.add(val.x);
            ys.add(val.y);
        }

        int smallestCorner = Integer.MAX_VALUE;
        Iterator<Integer> xItr = xs.iterator();
        while (xItr.hasNext()) {
            int a = xItr.next() + 1;
            
            Iterator<Integer> yItr = ys.iterator();
            while (yItr.hasNext()) {
                int b = yItr.next() + 1;

                int q1 = 0;
                int q2 = 0;
                int q3 = 0;
                int q4 = 0;

                for (int i = 0; i < cords.length; i++) {
                    if (cords[i].x > a && cords[i].y > b) {
                        q1++;
                    }
                    else if (cords[i].x < a && cords[i].y > b) {
                        q2++;
                    }
                    else if (cords[i].x < a && cords[i].y < b) {
                        q3++;
                    }
                    else {
                        q4++;
                    }
                }

                int maxQ = Math.max(Math.max(q1, q2), Math.max(q3, q4));
                smallestCorner = Math.min(smallestCorner, maxQ);
            }
        }
        pw.println(smallestCorner);
        pw.close();
        br.close();
    }
}

class Cord {
    int x;
    int y;

    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
