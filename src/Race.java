import java.util.*;
import java.io.*;

public class Race {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zaiah\\OneDrive - issaquah.wednet.edu\\T&P\\USACO\\RaceInput.txt"));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int maxSpeedCount = Integer.parseInt(st.nextToken());

        int[] finalSpeed = new int[maxSpeedCount];
        for (int i = 0; i < maxSpeedCount; i++) {
            finalSpeed[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < maxSpeedCount; i++) {
            System.out.println(bestFinish(0, length, 0, 0, finalSpeed[i]));
        }
        pw.close();
    }

    public static int getSummation(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int bestFinish(int distance, int length, int speed, int time, int max) {
        distance += speed;
        if (distance >= length && speed <= max) {
            return time;
        }
        if (distance >= length && speed > max) {
            return Integer.MAX_VALUE;
        }
        return Math.min(bestFinish(distance, length, Math.max(speed - 1, 0), time + 1, max), Math.min(bestFinish(distance, length, speed, time + 1, max), bestFinish(distance, length, speed + 1, time + 1, max)));
    }
}
