import java.util.*;
import java.io.*;

public class PromotionCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new File("promote.out"));

        StartEnd bronze = new StartEnd(0, 0);
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        bronze.start = Integer.parseInt(st1.nextToken());
        bronze.end = Integer.parseInt(st1.nextToken());

        StartEnd silver = new StartEnd(0, 0);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        silver.start = Integer.parseInt(st2.nextToken());
        silver.end = Integer.parseInt(st2.nextToken());
        
        StartEnd gold = new StartEnd(0, 0);
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        gold.start = Integer.parseInt(st3.nextToken());
        gold.end = Integer.parseInt(st3.nextToken());


        StartEnd plat = new StartEnd(0, 0);
        StringTokenizer st4 = new StringTokenizer(br.readLine());
        plat.start = Integer.parseInt(st4.nextToken());
        plat.end = Integer.parseInt(st4.nextToken());


        //everything is made now
        int startingPlayers = bronze.start + silver.start + gold.start + plat.start;
        int endingPlayers = bronze.end + silver.end + gold.end + plat.end;
        bronze.start += endingPlayers - startingPlayers;

        int proPlat = plat.end - plat.start;
        int proGold = gold.end - gold.start + proPlat;
        int proSilver = silver.end - silver.start + proGold;

        pw.println(proSilver);
        pw.println(proGold);
        pw.println(proPlat);
        pw.close();
        br.close();
    }
}

class StartEnd {
    int start;
    int end;
    int dif;

    public StartEnd(int start, int end) {
        this.start = start;
        this.end = end;
        dif = end - start;
    }
}
