import java.io.*;
import java.util.*;

public class MeasuringTraffic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter pw = new PrintWriter("traffic.out");

        int n = Integer.parseInt(br.readLine());

        Sensor[] sensors = new Sensor[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sensors[i] = new Sensor(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int min = 0;
        int max = 1000000;
        for (int i = n - 1; i >= 0; i--) {
            if (sensors[i].status.equals("none")) {
                min = Math.max(min, sensors[i].min);
                max = Math.min(max, sensors[i].max);
            }
            else if (sensors[i].status.equals("on")) {
                min = min - sensors[i].max;
                max = max - sensors[i].min;
            }
            else if (sensors[i].status.equals("off")) {
                min = min + sensors[i].min;
                max = max + sensors[i].max;
            }
            min = Math.max(min, 0);
        }

        pw.println(min + " " + max);

        min = 0;
        max = 1000000;
        for (int i = 0; i < n; i++) {
            if (sensors[i].status.equals("none")) {
                min = Math.max(min, sensors[i].min);
                max = Math.min(max, sensors[i].max);
            }
            else if (sensors[i].status.equals("on")) {
                min = min + sensors[i].min;
                max = max + sensors[i].max;
            }
            else if (sensors[i].status.equals("off")) {
                min = min - sensors[i].max;
                max = max - sensors[i].min;
            }
            min = Math.max(min, 0);
        }

        pw.println(min + " " + max);
        pw.close();
        br.close();
    }
}

class Sensor {
    String status;
    int min;
    int max;

    public Sensor(String status, int min, int max) {
        this.status = status;
        this.min = min;
        this.max = max;
    }
}
