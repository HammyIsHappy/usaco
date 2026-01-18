import java.io.*;
import java.util.*;

public class MooinTime {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        
        int length = Integer.parseInt(s.nextToken());
        int minMoos = Integer.parseInt(s.nextToken());
        String file = br.readLine();

        br.close();
        Map<String, Integer> mooCount = new HashMap<String, Integer>();
        for (int i = 0; i < length - 2; i++) {
            char[] current = file.substring(i, i + 3).toCharArray();
            if (current[0] != current[1] && current[1] == current[2]) {
                mooCount.put(file.substring(i, i + 3), mooCount.getOrDefault(file.substring(i, i + 3), 0) + 1);
            }
        }

        char[] arr = file.toCharArray();
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] temp = arr.clone();
        for (int i = 0; i < 26; i++) {
            Map<String, Integer> indivMooCount = new HashMap<String, Integer>(mooCount);
            for (int j = 0; j < arr.length; j++) {
                temp[j] = letters[i];
                
                indivMooCount = new HashMap<String,Integer>(mooCount);

                if (j < arr.length - 2 && j >= 2) {
                    String s1 = "" + arr[j - 2] + arr[j - 1] + arr[j];
                    String s2 = "" + arr[j - 1] + arr[j] + arr[j + 1];
                    String s3 = "" + arr[j] +  arr[j + 1] + arr[j + 2];
                    if (indivMooCount.containsKey(s1)) {indivMooCount.put(s1, indivMooCount.get(s1) - 1);}
                    if (indivMooCount.containsKey(s2)) {indivMooCount.put(s2, indivMooCount.get(s2) - 1);}
                    if (indivMooCount.containsKey(s3)) {indivMooCount.put(s3, indivMooCount.get(s3) - 1);}

                    if (temp[j - 2] != temp[j - 1] && temp[j - 1] == temp[j]) {
                        String cur = "" + temp[j - 2] + temp[j - 1] + temp[j];
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    }
                    if (temp[j - 1] != temp[j] && temp[j] == temp[j + 1]) {
                        String cur = "" + temp[j - 1] + temp[j] + temp[j + 1];
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    }
                    if (temp[j] != temp[j + 1] && temp[j + 1] == temp[j + 2]) {
                        String cur = "" + temp[j] + temp[j + 1] + temp[j + 2];
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    }
                }
                else if (j > arr.length - 2) {
                    String s1 = "" + arr[arr.length - 3] + arr[arr.length - 2] + arr[arr.length - 1];
                    if (indivMooCount.containsKey(s1)) {indivMooCount.put(s1, indivMooCount.get(s1) - 1);}
                    
                    if (temp[arr.length - 3] != temp[arr.length - 2] && temp[arr.length - 2] == temp[arr.length - 1]) {
                        char[] current = {temp[arr.length - 3], temp[arr.length - 2], temp[arr.length - 1]};
                        String cur = new String(current);
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    } 
                }
                else if (j == 0) {
                    char[] c1 = {arr[0], arr[1], arr[2]};
                    String s1 = new String(c1);
                    if (indivMooCount.containsKey(s1)) {indivMooCount.put(s1, indivMooCount.get(s1) - 1);}

                    if (temp[0] != temp[1] && temp[1] == temp[2]) {
                        char[] current = {temp[0], temp[1], temp[2]};
                        String cur = new String(current);
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    }
                }
                else if (j == 1 && arr.length > 4) {
                    char[] c1 = {arr[0], arr[1], arr[2]};
                    String s1 = new String(c1);
                    if (indivMooCount.containsKey(s1)) {indivMooCount.put(s1, indivMooCount.get(s1) - 1);}
                    char[] c2 = {arr[1], arr[2], arr[3]};
                    String s2 = new String(c2);
                    if (indivMooCount.containsKey(s2)) {indivMooCount.put(s2, indivMooCount.get(s2) - 1);}

                    if (temp[0] != temp[1] && temp[1] == temp[2]) {
                        char[] current = {temp[0], temp[1], temp[2]};
                        String cur = new String(current);
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    }
                    if (temp[1] != temp[2] && temp[2] == temp[3]) {
                        char[] current = {temp[1], temp[2], temp[3]};
                        String cur = new String(current);
                        indivMooCount.put(cur, indivMooCount.getOrDefault(cur, 0) + 1);
                    }
                }
                
                Set<String> moos = indivMooCount.keySet();
                for (String moo : moos) {
                    if (indivMooCount.get(moo) >= minMoos) {
                        mooCount.put(moo, indivMooCount.get(moo));
                    }
                }
                temp[j] = arr[j];
            }
        }
        

        Set<String> moos = mooCount.keySet();
        TreeSet<String> goodMoos = new TreeSet<String>();
        for (String moo : moos) {
            if (mooCount.get(moo) >= minMoos) {
                goodMoos.add(moo);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(goodMoos.size() + "\n");
        for (String moo : goodMoos) {
            sb.append(moo + "\n");
        }
        System.out.print(sb);
    }

    public static boolean isMoo(char[] arr) {
        if (arr[0] != arr[1] && arr[1] == arr[2]) {
            return true;
        }
        return false;
    }
}
