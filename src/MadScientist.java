import java.util.*;
import java.io.*;

public class MadScientist {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter("breedflip.out");

        int length = Integer.parseInt(br.readLine().trim());
        char[] a = br.readLine().trim().toCharArray();
        char[] b = br.readLine().trim().toCharArray();
        br.close();
        
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (b[i] != a[i]) {
                for (int j = i; b[j] != a[j] && j < length; j++) {
                    b[j] = a[j];
                }
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
}
