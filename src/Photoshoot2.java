import java.util.*;
import java.io.*;

public class Photoshoot2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int length = Integer.parseInt(br.readLine().trim());

        ArrayList<Integer> working = new ArrayList<Integer>(length);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            working.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> goal = new ArrayList<Integer>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            goal.add(Integer.parseInt(st1.nextToken()));
        }
        
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            if (!goal.get(i).equals(working.get(i))) {
                for (int j = i + 1; j < length; j++) {
                    if (working.get(j).equals(goal.get(i))) {
                        working.add(i, working.remove(j));
                        count++;
                    }
                }
            }
        } 


        pw.println(count);
        pw.close();
    }
}
