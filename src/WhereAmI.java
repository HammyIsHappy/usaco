import java.util.*;
import java.io.*;


public class WhereAmI {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("whereami.in"));
        int count = s.nextInt();
        String colors = s.next();
        s.close();
        int number = longest(count, colors);
        PrintWriter pw = new PrintWriter("whereami.out");
        pw.println(number);
        pw.close();
    }

    public static int longest(int count, String colors) {
        if (colors.length() == 1) {
            return 1;
        }
        //for testing lengths
        for (int i = 1; i < count; i++) {
            boolean thisItr = true;
            for (int j = 0; j < count - i; j++) {
                for (int k = j + 1; k < count - i + 1; k++) {
                    String a = colors.substring(j, j + i);
                    String b = colors.substring(k, k + i);

                    if (a.equals(b)) {
                        thisItr = false;
                        break;
                    }
                }
                if (!thisItr) {
                    break;
                }
            }
            if (thisItr == true) {
                return i;
            }
        }
        return count;
    }
}
