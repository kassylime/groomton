package week3;

import java.util.*;

public class day3 {
    static int N, K;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class dfs {
        int r, c;

        public dfs(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] score = new int[31];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    score [matrix[i][j]] += search(i, j);
                }
            }
        }

        int max = 0;
        int result = 0;

        for (int i = 1; i < 31; i++) {
            if (score [i] == 0) {
                continue;
            }
            if (score [i] >= max) {
                max = score [i];
                result = i;
            }
        }

        System.out.println(result);
    }

    static int search(int r, int c) {
        Queue<dfs> queue = new LinkedList<>();
        queue.offer(new dfs(r, c));
        visited[r][c] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            dfs cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (inSpace(nr, nc) && !visited[nr][nc] && matrix[nr][nc] == matrix[r][c]) {
                    queue.offer(new dfs(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }

        if (cnt < K) {
            return 0;
        } else {
            return 1;
        }
    }

    static boolean inSpace(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
