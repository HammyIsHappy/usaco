import java.util.*;
import java.io.*;

public class LivestockLineup {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new File("lineup.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("lineup.out");
        
        int ruleCount = Integer.parseInt(st.nextToken());
        String[][] pairs = new String[ruleCount][2];
        for (int i = 0; i < ruleCount; i++) {
            StringTokenizer strtok = new StringTokenizer(br.readLine());
            pairs[i][0] = strtok.nextToken();
            pairs[i][1] = strtok.nextToken();
        }

        ArrayList<String> lineup = new Arrayist<String>();
        lineup.add("Beatrice");
        lineup.add("Sue");
        lineup.add("Belinda");
        lineup.add("Bessie");
        lineup.add("Betsy");
        lineup.add("Blue");
        lineup.add("Bella");
        lineup.add("Buttercup");
        Collections.sort(lineup);

        //Create all permutations now.
        ArrayList<ArrayList<String>> allLineups = new ArrayList<ArrayList<String>>();
        public static void buildAll(ArrayList<String> aLineup) {
            if (allLineups.size() == Math.factorial(8)) {
                
            }
            ArrayList<String> newLineup = new ArrayList<String>();
            buildAll(lineup);
        }
        //Check for valid ones
    }
}