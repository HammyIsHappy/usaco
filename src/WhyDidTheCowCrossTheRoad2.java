import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoad2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter("circlecross.out");
        
        String cows = br.readLine();
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i < 52; i++) {
            arr.add(cows.substring(i, i + 1));
        }
        HashSet<String> set = new HashSet<String>(arr);

        Iterator<String> itr = set.iterator();
        int count = 0;
        while (itr.hasNext()) {
            String letter = itr.next();
            ArrayList<String> seen = new ArrayList<String>();
            if (arr.indexOf(letter) != -1) {
                int i = arr.indexOf(letter);
                do {
                    if (!seen.contains(arr.get(i)) && !arr.get(i).equals(letter)) {
                        seen.add(arr.get(i));
                    }
                    else if (seen.contains(arr.get(i))) {
                        seen.remove(arr.get(i));
                    }
                    i++;
                } while (!letter.equals(arr.get(i)));

                count += seen.size();
                arr.remove(letter);
                arr.remove(letter);
            }
        }

        pw.println(count);
        pw.close();
        br.close();
    }
}

