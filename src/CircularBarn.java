import java.io.*;
import java.util.*;

public class CircularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter("cbarn.out");

        int n = Integer.parseInt(br.readLine());
        int[] rooms = new int[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int distance = 0;
            int index;
            int count = 1;
            if (i == n - 1) {index = 0;}
            else {index = i + 1;}
            while (index != i) {
                distance += rooms[index] * count;
                count++;
                index++;
                if (index == n) {index = 0;}
            }
            min = Math.min(min, distance);
        }

        pw.println(min);
        pw.close();
        br.close();
    }
}