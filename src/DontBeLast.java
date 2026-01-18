import java.io.*;
import java.util.*;

public interface DontBeLast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter("notlast.out");

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> cows = new HashMap<String, Integer>();
        cows.put("Bessie", 0);
        cows.put("Elsie", 0);
        cows.put("Daisy", 0);
        cows.put("Gertie", 0);
        cows.put("Annabelle", 0);
        cows.put("Maggie", 0);
        cows.put("Henrietta", 0);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cow = st.nextToken();
            int current = cows.get(cow);
            cows.replace(cow, current + Integer.parseInt(st.nextToken()));
        }

        Set<String> names = cows.keySet();
        int min = Integer.MAX_VALUE;
        for (String name : names) {
            min = Math.min(min, cows.get(name));
        }
        Set<String> toRemove = new HashSet<String>();
        for (String name : names) {
            if (cows.get(name) == min) {toRemove.add(name);}
        }
        for (String cow : toRemove) {
            cows.remove(cow);
        }

        ArrayList<String> second = new ArrayList<String>();
        names = cows.keySet();
        min = Integer.MAX_VALUE;
        for (String name : names) {
            min = Math.min(min, cows.get(name));
        }

        for (String name : names) {
            if (cows.get(name) == min) {second.add(name);}
        }

        if (second.size() == 1) {pw.println(second.get(0));}
        else {pw.println("Tie");}
        pw.close();
        br.close();
        //lets hope this works
    }
}
