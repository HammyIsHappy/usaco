
import java.util.*;
import java.io.*;

public class PhotoshootHard {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        char[] lineup= br.readLine().trim().toCharArray();

        int hCount = 0;
        int gCount = 0;
        for (int i = 0; i < length; i++) {
            if (lineup[i] == 'H') {
                hCount++;
            }
            else {
                gCount++;
            }
        }
        
        for (int i = 0; i < length; i += 2) {
            if (lineup[i] == 'H' && lineup[i+1] == 'H') {
                hCount--;
            }
        }

        for (int i = 0; i < 10; i++) {
            boolean breaker = false;
            for (int k = 0; k < length; k++) {
                
            }
            
            if ()
        }

    }

    public static void reverse(char[] array, int start, int end) {
        for (int i = start; i < (start + end) / 2; i++) {
            swap(array, i, end - i);
        }
    }

    public static void swap(char[] array, int start, int end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}