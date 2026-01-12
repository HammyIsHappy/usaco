import java.io.*;
import java.util.*;

public class TheLostCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter("lostcow.out");
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int FJPos = Integer.parseInt(st.nextToken());
        int FJInitial = FJPos;
        int bessiePos = Integer.parseInt(st.nextToken());
        boolean bessieInFront = true;
        if (Math.max(FJPos, bessiePos) == FJPos) {bessieInFront = false;}

        int distTraveled = 0;
        for (int i = 0; true; i++) {
            if (i == 0) {
                distTraveled++;
                FJPos++;
            }
            else {
                if (i % 2 == 1) {
                    distTraveled += (FJPos - FJInitial) * 3;
                    FJPos -= (FJPos - FJInitial) * 3;
                }
                if (i % 2 == 0) {
                    distTraveled += (FJInitial - FJPos) * 3;
                    FJPos += (FJInitial - FJPos) * 3;
                }
            }
            if (bessieInFront && FJPos >= bessiePos) {
                distTraveled -= (FJPos - bessiePos);
                break;
            }
            if (!bessieInFront && bessiePos >= FJPos) {
                distTraveled -= (bessiePos - FJPos);
                break;
            }
        }
        pw.println(distTraveled);
        pw.close();
        br.close();
    }
}
