import java.util.*;
import java.io.*;

public class TeamTicTacToe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter("tttt.out");

        char[][] board = new char[3][3];
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
                set.add(line.charAt(j));
            }
        }

        ArrayList<Character> winners = new ArrayList<Character>();
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && winners.indexOf(board[i][0]) == -1) {

                winners.add(board[i][0]);
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && winners.indexOf(board[0][i]) == -1) {
                winners.add(board[0][i]);
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && winners.indexOf(board[0][0]) == -1) {
            winners.add(board[0][0]);
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && winners.indexOf(board[0][2]) == -1) {
            winners.add(board[0][2]);
        }
        pw.println(winners.size());

        ArrayList<ArrayList<Character>> teams = new ArrayList<ArrayList<Character>>();
        Object[] arr = set.toArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ArrayList<Character> temp = new ArrayList<Character>();
                temp.add((char) arr[i]);
                temp.add((char) arr[j]);
                teams.add(temp);
            }
        }

        ArrayList<ArrayList<Character>> teamWinners = new ArrayList<ArrayList<Character>>();
        for (ArrayList<Character> team : teams) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == team.get(0) || board[i][0] == team.get(1)) && (board[i][1] == team.get(0) || board[i][1] == team.get(1)) && (board[i][2] == team.get(0) || board[i][2] == team.get(1)) && (board[i][0] != board[i][1] || board[i][1] != board[i][2]) && teamWinners.indexOf(team) == -1) {
                    teamWinners.add(team);
                }
                if ((board[0][i] == team.get(0) || board[0][i] == team.get(1)) && (board[1][i] == team.get(0) || board[1][i] == team.get(1)) && (board[2][i] == team.get(0) || board[2][i] == team.get(1)) && (board[0][i] != board[1][i] || board[1][i] != board[2][i]) && teamWinners.indexOf(team) == -1) {
                    teamWinners.add(team);
                }
            }

            if ((board[0][0] == team.get(0) || board[0][0] == team.get(1)) && (board[1][1] == team.get(0) || board[1][1] == team.get(1)) && (board[2][2] == team.get(0) || board[2][2] == team.get(1)) && (board[0][0] != board[1][1] || board[1][1] != board[2][2]) && teamWinners.indexOf(team) == -1) {
                teamWinners.add(team);
            }
            if ((board[2][0] == team.get(0) || board[2][0] == team.get(1)) && (board[1][1] == team.get(0) || board[1][1] == team.get(1)) && (board[0][2] == team.get(0) || board[0][2] == team.get(1)) && (board[2][0] != board[1][1] || board[1][1] != board[0][2]) && teamWinners.indexOf(team) == -1) {
                teamWinners.add(team);
            }
        }

        pw.println(teamWinners.size());
        pw.close();
        br.close();
    }
}
