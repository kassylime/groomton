package week2;

import java.io.*;
import java.util.StringTokenizer;

public class day5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] start = new int[2][2];
        for (int i = 0; i < 2; i++) {9,.

            st = new StringTokenizer(br.readLine(), " ");
            start[i][0] = Integer.parseInt(st.nextToken()) - 1;
            start[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        String[][] g = new String[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                g[i][j] = st.nextToken();
            }
        }
        int goorm = search(start[0][0], start[0][1], g, N);
        int player = search(start[1][0], start[1][1], g, N);

        if (goorm > player) {
            bw.write("goorm");
            bw.write(String.valueOf(goorm));
        } else {
            bw.write("player");
            bw.write(String.valueOf(player));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int search(int r, int c, String[][] g, int N) {
        int result = 1;
        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;
        while (true) {
            int move = Integer.parseInt(g[r][c].substring(0, g[r][c].length() - 1));
            char dir = g[r][c].charAt(g[r][c].length() - 1);
            for (int i = 0; i < move; i++) {
                if (dir == 'U') {
                    r = r - 1 < 0 ? N - 1 : r - 1;
                } else if (dir == 'D') {
                    r = r + 1 == N ? 0 : r + 1;
                } else if (dir == 'L') {
                    c = c - 1 < 0 ? N - 1 : c - 1;
                } else {
                    c = c + 1 == N ? 0 : c + 1;
                }
                if (visited[r][c]) {
                    return result;
                }
                result++;
                visited[r][c] = true;
            }
        }
    }
}
