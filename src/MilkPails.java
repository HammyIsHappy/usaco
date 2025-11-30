import java.util.*;
import java.io.*;
import java.io.PrintWriter;

public class MilkPails {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("pails.in"));
        int xSize = s.nextInt();
        int ySize = s.nextInt();
        int mSize = s.nextInt();
        s.close();
        PrintWriter pw = new PrintWriter(new File("pails.out"));
        pw.println(max(xSize, ySize, mSize));
        //System.out.println(max(xSize, ySize, mSize));
        pw.close();
    }

    public static int max(int xSize, int ySize, int mSize) {
        if (mSize % xSize == 0 || mSize % ySize == 0 || xSize == 1) {
            return mSize;
        }
        //Fills it up as much as possible with just x
        int total = 0;
        int xCount = 0;
        int yCount = 0;
        while (total + xSize <= mSize) {
            total += xSize;
            xCount++;
        }
        //System.out.println(total);
        
        int maxTotal = total;
        for (xCount = xCount;xCount != 0; xCount--) {
            total -= xSize;
            if (total + ySize <= mSize) {
                total += ySize;
                yCount++;
            }
            if (total > maxTotal) {
                maxTotal = total;
            }
        }
        return maxTotal;
    }
}