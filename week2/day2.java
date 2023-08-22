package week2;

import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 격자의 크기 N
        int K = scanner.nextInt(); // 찾고 싶은 깃발의 값 K

        int[][] gameBoard = new int[N][N]; // 게임판

        // 게임판 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                gameBoard[i][j] = scanner.nextInt();
            }
        }

        int kFlagCount = countKFlags(N, K, gameBoard); // 깃발의 개수 계산
        System.out.println(kFlagCount); // 결과 출력

        scanner.close();
    }

    public static int countKFlags(int N, int K, int[][] gameBoard) {
        // 주변 위치 계산을 위한 dy, dx 배열
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int kFlagCount = 0; // 깃발 개수를 저장할 변수

        // 모든 격자를 돌면서 깃발의 개수를 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (gameBoard[i][j] == 0) { // 현재 위치에 구름이 없는 경우
                    int countClouds = 0; // 주변 구름 개수를 저장할 변수
                    for (int dir = 0; dir < 8; dir++) { // 주변 8방향을 검사
                        int ny = i + dy[dir]; // 주변 위치의 행 인덱스
                        int nx = j + dx[dir]; // 주변 위치의 열 인덱스
                        if (ny >= 0 && ny < N && nx >= 0 && nx < N && gameBoard[ny][nx] == 1) {
                            countClouds++; // 주변에 구름이 있으면 카운트 증가
                        }
                    }
                    if (countClouds == K) { // 주변 구름 개수가 K와 같다면
                        kFlagCount++; // 깃발 개수 증가
                    }
                }
            }
        }

        return kFlagCount; // 최종 깃발 개수 반환
    }
}
