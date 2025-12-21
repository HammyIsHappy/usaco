import java.util.*;
import java.io.*;

public class SleepyCowHerding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("herding.out");
        
        int[] positions = new int[3];
        for (int i = 0; i < 3; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(positions);

        int min;
        int max;
        if (positions[2] - positions[0] == 2) {
            min = 0;
        }
        else if (positions[0] + 2 == positions[1] || positions[1] + 2 == positions[2]) {
            min = 1;
        }
        else {
            min = 2;
        }

        max = Math.max(positions[1] - positions[0], positions[2] - positions[1]) - 1;

        pw.println(min);
        pw.println(max);
        pw.close();
        br.close();
    }
}
