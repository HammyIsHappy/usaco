import java.io.*;
import java.util.*;

class Pair {
    private int a;
    private int b;
    
    public Pair(int ax, int bx) {
        a = ax;
        b = bx;
    }

    public int to() {
        return b;
    }

    public int from() {
        return a;
    }

    public String toString() {
        return "[" + a + "," + b + "]";
    }
}

public class TimeIsMoony {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("time.in"));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("time.out");

        int numOfCities = Integer.parseInt(st1.nextToken());
        int numOfRoads = Integer.parseInt(st1.nextToken());
        int costConst = Integer.parseInt(st1.nextToken());

        //index i = money given from going to city i
        int[] moneyFromCity = new int[numOfCities];
        StringTokenizer st2 = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < numOfCities; i++) {
            moneyFromCity[i] = Integer.parseInt(st2.nextToken());
        }

        //index i = nothing
        //each index has a pair, a is from, b is to
        Pair[] roads = new Pair[numOfRoads];
        for (int i = 0; i < numOfRoads; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            roads[i] = new Pair(Integer.parseInt(st3.nextToken()) - 1,Integer.parseInt(st3.nextToken()) - 1);
            //System.out.println(roads[i]);        
        }
        br.close();
        
        int[][] profitChart = new int[1000][numOfCities];
        for (int[] row : profitChart) {
            Arrays.fill(row, -1);
        }
        profitChart[0][0] = 0;

        int maxProfit = 0;
        for (int t = 0; t < 1000; t++) {
            for (int i = 0; i < numOfCities; i++) {
                if (profitChart[t][i] == -1) {
                    continue;
                }

                for (int j = 0; j < numOfRoads; j++) {
                    if (roads[j].from() == i && t + 1 < 1000) {
                        profitChart[t + 1][roads[j].to()] = Math.max(profitChart[t + 1][roads[j].to()], profitChart[t][i] + moneyFromCity[roads[j].to()]);
                    }
                }
            }
            maxProfit = Math.max(maxProfit, profitChart[t][0] - costConst * t * t);
        }
        //System.out.println(maxProfit);
        pw.println(maxProfit);
        pw.close();
    }
}
