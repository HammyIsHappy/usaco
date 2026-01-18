import java.io.*;
import java.util.*;

public class Hoofball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter pw = new PrintWriter("hoofball.out");
        int count = Integer.parseInt(br.readLine());
        int[] cows = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows);

        Map<Integer, Integer> passes = new HashMap<Integer, Integer>();
        for (int i = 0; i < cows.length; i++) {
            int closest;
            if (i == 0) {closest = 1;}
            else if (i == count - 1) {closest = count - 2;}
            else
            {
                int closestDistnace = Math.min(cows[i] - cows[i - 1], cows[i + 1] - cows[i]);
                if (closestDistnace == cows[i + 1] - cows[i] && closestDistnace == cows[i] - cows[i - 1]) {closest = i - 1;}
                else if (closestDistnace == cows[i + 1] - cows[i]) {closest = i + 1;}
                else {closest = i - 1;}
            }
            passes.put(i, closest);
        }

        Set<Integer> posSet = passes.keySet();
        ArrayList<Integer> startCows = new ArrayList<Integer>();
        for (Integer cow : posSet) {
            boolean starter = true;
            for (Integer c : posSet) {
                if (passes.get(c) == cow) {starter = false;}
            }

            if (starter) {startCows.add(cow);}
        }
        
        ArrayList<Integer> isolated = new ArrayList<Integer>();
        for (int i = 0; i < cows.length; i++) {
            isolated.add(i);
        }
        Set<Integer> visited = new HashSet<Integer>();

        for (Integer cow : startCows) {
            visited.add(cow);
            int cur = passes.get(cow);
            for (int i = 0; i < 100; i++) {
                visited.add(cur);
                cur = passes.get(cur);
            }
        }

        isolated.removeAll(visited);
        int balls = startCows.size() + (isolated.size() / 2);

        //pw.println(startCows.size());
        //pw.println(isolated.size() / 2);
        pw.println(balls);
        pw.close();
        br.close();
    }
}
