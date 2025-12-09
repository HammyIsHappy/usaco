import java.util.*;
import java.io.*;

public class ShellGame {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("shell.out");

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Pair> swaps = new ArrayList<Pair>();
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            StringTokenizer sti = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(sti.nextToken());
            int b = Integer.parseInt(sti.nextToken());
            int g = Integer.parseInt(sti.nextToken());
            swaps.add(new Pair(a, b));
            guesses.add(g);
        }
        br.close();

        int maxCount = 0;
        for (int startPos = 0; startPos < 3; startPos++) {
            int count = 0;
            int pos = startPos + 1;
            for (int i = 0; i < swaps.size(); i++) {
                if (swaps.get(i).getA() == pos) {
                    pos = swaps.get(i).getB();
                }
                else if (swaps.get(i).getB() == pos) {
                    pos = swaps.get(i).getA();
                }
                if (guesses.get(i) == pos) {count++;}
            }
            maxCount = Math.max(count, maxCount);
        }
        pw.println(maxCount);
        pw.close();
    }
    
}

class Pair {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
