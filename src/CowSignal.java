import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowSignal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("cowsignal.out");

        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < xSize; i++) {
            char[] line = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder(100);
            for (int j = 0; j < ySize; j++) {
                for (int z = 0; z < k; z++) {
                    sb.append(line[j]);
                }
            }
            for (int z = 0; z < k; z++) {
                pw.println(sb);
            }
        }
        pw.close();
        br.close();
    }
}
