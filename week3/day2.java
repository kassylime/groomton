package week3;

import java.util.*;

public class day2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;
        int[][] matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, N, matrix, visited, dy, dx);
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }

    // BFS
    public static void bfs(int x, int y, int N, int[][] matrix, boolean[][] visited, int[] dy, int[] dx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = current[0] + dx[k];
                int nextY = current[1] + dy[k];
                // 마을 안의 좌표인지 확인
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                    if (matrix[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
