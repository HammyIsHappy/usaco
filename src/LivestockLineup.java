import java.util.*;
import java.io.*;

class Pair {
    private String a;
    private String b;

    public String a() {
        return a;
    }
    public String b() {
        return b;
    }
    public Pair(String a, String b) {
        this.a = a;
        this.b = b;
    }
}

public class LivestockLineup {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("lineup.out");
        
        int ruleCount = Integer.parseInt(st.nextToken());
        ArrayList<Pair> rules = new ArrayList<Pair>();
        for (int i = 0; i < ruleCount; i++) {
            StringTokenizer strtok = new StringTokenizer(br.readLine());
            String a = strtok.nextToken();
            strtok.nextToken();
            strtok.nextToken();
            strtok.nextToken();
            strtok.nextToken();
            String b = strtok.nextToken();
            rules.add(new Pair(a, b));
        }
        br.close();

        ArrayList<String> lineup = new ArrayList<String>();
        /*lineup.add("Beatrice");
        lineup.add("Sue");
        lineup.add("Belinda");
        lineup.add("Bessie");
        lineup.add("Betsy");
        lineup.add("Blue");
        lineup.add("Bella");
        lineup.add("Buttercup");
        Collections.sort(lineup); */

        //Create all permutations now.
        ArrayList<ArrayList<String>> allLineups = new ArrayList<ArrayList<String>>();
        buildAll(lineup, allLineups);

        //test
        for (int i = 0; i < allLineups.size(); i++) {
            boolean valid = true;
            for (Pair rule : rules) {
                if (Math.abs(allLineups.get(i).indexOf(rule.a()) - allLineups.get(i).indexOf(rule.b())) > 1) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                for (String cow : allLineups.get(i)) {
                    pw.println(cow);
                }
                break;
            }
        }
        pw.close();
    }

    public static void buildAll(ArrayList<String> aLineup, ArrayList<ArrayList<String>> allLineups) {
        if (aLineup.size() == 8) {
            allLineups.add(aLineup);
            return;
        }
        for (String cow : aLineup) {
            if (!aLineup.contains(cow)) {
                aLineup.add(cow);
                buildAll(aLineup, allLineups);
                aLineup.remove(aLineup.size() - 1);
            }
        }
    }
}