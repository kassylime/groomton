package week3;

import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 입력된 통증 수치
        int A = scanner.nextInt(); // 아이템 A의 감소량
        int B = scanner.nextInt(); // 아이템 B의 감소량

        int minItems = calculateMinItems(N, A, B); // 최소 아이템 개수 계산

        System.out.println(minItems); // 결과 출력

        scanner.close();
    }

    public static int calculateMinItems(int N, int A, int B) {
        // 통증 수치를 만들기 위한 최소 아이템 개수를 저장하는 배열
        int[] dp = new int[N + 1];

        // dp 배열 초기화
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 각 통증 수치에 대한 최소 아이템 개수 계산
        for (int i = 1; i <= N; i++) {
            if (i >= A && dp[i - A] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - A] + 1);
            }
            if (i >= B && dp[i - B] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - B] + 1);
            }
        }

        // N 통증 수치를 만들기 위한 최소 아이템 개수 반환
        return dp[N] == Integer.MAX_VALUE ? -1 : dp[N];
    }
}
