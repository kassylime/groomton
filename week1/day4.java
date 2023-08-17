package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class day4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // n 입력 받기
        int n = Integer.parseInt(reader.readLine());

        // ki 배열 입력 받기
        String[] kiInput = reader.readLine().split(" ");
        int[] ki = new int[n];
        for (int i = 0; i < n; i++) {
            ki[i] = Integer.parseInt(kiInput[i]);
        }

        // 최대값과 인덱스 찾기
        int best = Arrays.stream(ki).max().getAsInt();
        int bestIdx = 0;
        for (int i = 0; i < n; i++) {
            if (ki[i] == best) {
                bestIdx = i;
                break;
            }
        }

        // 왼쪽 부분과 오른쪽 부분 나누기
        int[] left = Arrays.copyOfRange(ki, 0, bestIdx + 1);
        int[] right = Arrays.copyOfRange(ki, bestIdx, n);

        // 제대로 된 햄버거인지 검증
        if (isSorted(left) && isSortedDescending(right)) {
            // 제대로 된 햄버거라면 맛 구하기
            int sum = Arrays.stream(ki).sum();
            System.out.println(sum);
        } else {
            System.out.println(0);
        }

        reader.close();
    }

    // 배열이 정렬되어 있는지 확인하는 메서드
    private static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 배열이 내림차순으로 정렬되어 있는지 확인하는 메서드
    private static boolean isSortedDescending(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}