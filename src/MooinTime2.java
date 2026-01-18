import java.io.*;
import java.util.*;

public class MooinTime2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }

        Map<Long, Integer> counts = new HashMap<Long, Integer>();
        Map<Long, Integer> maxIndex = new HashMap<Long, Integer>();
        for (int i = n - 1; i >= 0; i--) {
            counts.put(arr[i], counts.getOrDefault(arr[i],0) + 1);
            if (counts.get(arr[i]) == 2) {
                maxIndex.put(arr[i], i);
            }
        }

        Set<Long> seenNums = new HashSet<Long>();
        int moos = 0;
        for (int i = 0; i < n - 2; i++) {
            if (!seenNums.contains(arr[i])){
                seenNums.add(arr[i]);
                for (Long num : maxIndex.keySet()) {
                    if (num != arr[i] && maxIndex.get(num) > i) {
                        moos++;
                    }
                }
            }
        }

        /*
        ArrayList<Long> seenNums = new ArrayList<Long>();
        int moos = 0;
        for (int i = 0; i < n - 2; i++) {
            if (!seenNums.contains(arr[i])) {
                seenNums.add(arr[i]);
                Map<Long, Integer> numCounts = new HashMap<Long, Integer>();
                for (int j = i + 1; j < n; j++) {
                    numCounts.put(arr[j], numCounts.getOrDefault(arr[j], 0) + 1);
                }
                for (Long num : numCounts.keySet()) {
                    if (num != arr[i] && numCounts.get(num) >= 2 ) {
                        moos++;
                    }
                }
            }
        }
            */

        System.out.println(moos);
    }
}
