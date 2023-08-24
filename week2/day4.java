package week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(firstLine.nextToken()); // 땅의 크기
        int K = Integer.parseInt(firstLine.nextToken()); // 폭탄을 떨어트릴 횟수

        char[][] map = new char[N][N]; // 땅의 상태 저장 배열
        int[][] bombs = new int[K][2]; // 폭탄 떨어트릴 좌표 배열

        // 땅의 상태 입력 받기
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j * 2); // 공백을 건너뛰기 위해 j * 2 인덱스 사용
            }
        }

        // 폭탄 좌표 입력 받기
        for (int i = 0; i < K; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            bombs[i][0] = Integer.parseInt(tokenizer.nextToken());
            bombs[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        // 땅의 상태 저장 배열
        int[] dy = {0, -1, 0, 1, 0};
        int[] dx = {0, 0, 1, 0, -1};
        int[][] arr = new int[N][N];

        for (int[] bomb : bombs) {
            int y = bomb[0] - 1;
            int x = bomb[1] - 1;

            for (int i = 0; i < 5; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (map[ny][nx] == '#') continue;
                if (map[ny][nx] == '0') arr[ny][nx] += 1;
                if (map[ny][nx] == '@') arr[ny][nx] += 2;
            }
        }

        // 최대 폭탄 값 찾기
        int maxBombValue = 0;
        for (int[] row : arr) {
            for (int value : row) {
                maxBombValue = Math.max(maxBombValue, value);
            }
        }

        System.out.println(maxBombValue);
    }
}
