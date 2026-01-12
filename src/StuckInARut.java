import java.io.*;
import java.util.*;

public class StuckInARut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cowCount = Integer.parseInt(br.readLine());
        
        ArrayList<Cow> cows = new ArrayList<Cow>();
        for (int i = 0; i < cowCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows.add(new Cow(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ArrayList<Cow> eastCows = new ArrayList<Cow>();
        ArrayList<Cow> northCows = new ArrayList<Cow>();
        for (int i = 0; i < cowCount; i++) {
            if (cows.get(i).direction.equals("E")) {
                eastCows.add(cows.get(i));
            }
            else {
                northCows.add(cows.get(i));
            }
        }

        ArrayList<CloseCows> pairs = new ArrayList<CloseCows>();
        for (int i = 0; i < eastCows.size(); i++) {
            double minDistance = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < northCows.size(); j++) {
                if (northCows.get(j).y < eastCows.get(i).y && northCows.get(j).x > northCows.get(i).x) {
                    if (Math.sqrt(Math.pow(northCows.get(j).x - eastCows.get(i).x, 2) + Math.pow(eastCows.get(i).y - northCows.get(j).y, 2)) < minDistance) {
                        index = j;
                        minDistance = Math.sqrt(Math.pow(northCows.get(j).x - eastCows.get(i).x, 2) + Math.pow(eastCows.get(i).y - northCows.get(j).y, 2));
                    }
                }
            }
            if (index != -1) {pairs.add(new CloseCows(eastCows.get(i), northCows.get(index), minDistance));}
        }

        
        for (CloseCows pair : pairs) {
            if (pair.distanceApart == ) {
                
            }
        }

        /*
        for (int i = 0; i < eastCows.size();) {
            int closestCowIndex = -1;
            for (int j = 0; j < northCows.size(); j++) {
                if (northCows.get(j).y < eastCows.get(i).y && northCows.get(j).x > northCows.get(i).x) {
                    if (closestCowIndex == -1) {closestCowIndex = j;}
                    else {closestCowIndex = Math.min(j, closestCowIndex);}
                }
            }
            
            if (closestCowIndex != -1) {
                int width = northCows.get(closestCowIndex).x - eastCows.get(i).x;
                int height = eastCows.get(i).y - northCows.get(closestCowIndex).y;
                if (width > height) {eastCows.get(i).distance = width;}
                else if (width < height) {northCows.get(closestCowIndex).distance = height;}
                else if (width == height) {continue;}
            }
            else {

            }         
        } */
    }
}
class CloseCows {
    Cow a;
    Cow b;
    double distanceApart;

    public CloseCows(Cow aa, Cow bb, double dist) {
        a = aa;
        b = bb;
        distanceApart = dist;
    }
}

class Cow {
    String direction;
    int x;
    int y;
    int distance;

    public Cow(String a, int xp, int yp) {
        direction = a;
        x = xp;
        y = yp;
    }
}