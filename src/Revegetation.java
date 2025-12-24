import java.util.*;
import java.io.*;

public class Revegetation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter("revegetate.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pastureCount = Integer.parseInt(st.nextToken());
        int cowCount = Integer.parseInt(st.nextToken());

        int[] pastures = new int[pastureCount];
        for (int i = 0; i < pastureCount; i++) {
            pastures[i] = 4;
        }

        ArrayList<cow> cows = new ArrayList<>();
        for (int i = 0; i < cowCount; i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();

        for (int currentPasture = 0; currentPasture < pastureCount; currentPasture++) {
            for (int grass = 1; grass < 5; grass++) {
                boolean valid = true;
                for (cow c : cows) {
                    if (c.getPasture1() == currentPasture && pastures[c.getPasture2()] == grass) {
                        valid = false;
                        break;
                    }
                    if (c.getPasture2() == currentPasture && pastures[c.getPasture1()] == grass) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    pastures[currentPasture] = grass;
                    break;
                }
            }
        }
        for (int num : pastures) {
            pw.print(num);
        }
        pw.close();
    }
}

class cow {
    int pasture1;
    int pasture2;

    public cow(int p1, int p2) {
        pasture1 = Math.min(p1, p2) - 1;
        pasture2 = Math.max(p1, p2) - 1;
    }

    public int getPasture1() {
        return pasture1;
    }

    public int getPasture2() {
        return pasture2;
    }
}