import java.util.*;
import java.io.*;

public class WhyCross3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter("cowqueue.out");

        int n = Integer.parseInt(br.readLine());
        
        //<Arrival, process time>
        TreeMap<Integer,Integer> queTimes = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int proccessTime = Integer.parseInt(st.nextToken());
            queTimes.put(arrival, queTimes.getOrDefault(arrival, 0) + proccessTime);
        }
        br.close();
        
        Set<Integer> keys = queTimes.keySet();
        int count = 0;
        for (Integer key : keys) {
            if (key > count) {count = key;}
            count += queTimes.get(key);
        }

        pw.println(count);
        pw.close();
    }
}

