import java.util.*;
import java.io.*;

public class BlockGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter("blocks.out");

        int wordCount = Integer.parseInt(br.readLine().trim());
        ArrayList<Pair> words = new ArrayList<Pair>(wordCount);
        for (int i = 0; i < wordCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            words.add(new Pair(st.nextToken(), st.nextToken()));
        }
        br.close();

        int[] amounts = new int[26];
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < wordCount; j++) {
                count += Math.max(
                letterCount(words.get(j).getA(), letters.substring(i, i + 1)), 
                letterCount(words.get(j).getB(), letters.substring(i, i + 1)));
            }
            amounts[i] = count;
        }

        for (int num : amounts) {
            pw.println(num);
        }
        pw.close();
    }

    public static int letterCount(String word, String l) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + 1).equals(l)){
                count++;
            }
        }
        return count;
    }
}

class Pair {
    private String a;
    private String b;

    public Pair(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }
}