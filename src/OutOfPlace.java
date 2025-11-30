import java.util.*;
import java.io.*;

public class OutOfPlace {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter("outofplace.out");

        int cowCount = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> heights = new ArrayList<Integer>();
        for (int i = 0; i < cowCount; i++) {
            heights.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        pw.println(countSwaps(heights));
        pw.close();
    }

    public static int countSwaps(List<Integer> heights) {
        ArrayList<Integer> sorted = new ArrayList<Integer>(heights);
        Collections.sort(sorted);
        if (heights.equals(sorted)) {return 0;}
        if (heights.size() == 2) {return 1;}

        int count = 0;
        while (!heights.equals(sorted)) {
            for (int i = 0; i < heights.size() - 1; i++) {
                if (!heights.get(i).equals(sorted.get(i))) {
                    int smallest = 100000000;
                    int index = 0;
                    for (int j = i + 1; j < heights.size(); j++) {
                        if (heights.get(j) <= smallest) {
                            smallest = heights.get(j);
                            index = j;
                        }
                    }
                    Collections.swap(heights, i, index);
                    count++;
                }
            }
        }
        return count;
    }
}
