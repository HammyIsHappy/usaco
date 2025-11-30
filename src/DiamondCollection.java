import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DiamondCollection {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("diamond.in")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lineCount = Integer.parseInt(st.nextToken());
        int maxDif = Integer.parseInt(st.nextToken());
        
        //Creates array
        int[] diamonds = new int[lineCount];
        for (int i = 0; i < lineCount; i++) {
            diamonds[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(diamonds);

        int max = 0;
        for (int i = 0; i < diamonds.length; i++) {
            int count = 1;
            for (int j = i + 1; j < diamonds.length; j++) {
                if (diamonds[j] - diamonds[i] <= maxDif) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        PrintWriter pw = new PrintWriter(new FileWriter(new File("diamond.out")));
        pw.println(max);
        pw.close();
    }
}
