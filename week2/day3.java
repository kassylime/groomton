package week2;

import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 플레이어의 통증 수치

        int[] items = {14, 7, 1}; // 아이템의 감소 수치 (크기별로 내림차순 정렬된 상태)

        int itemIndex = 0; // 아이템 인덱스
        int itemCount = 0; // 아이템 개수

        while (n > 0) {
            if (n >= items[itemIndex]) {
                n -= items[itemIndex];
                itemCount++;
            } else {
                itemIndex++;
            }
        }

        System.out.println(itemCount);
    }
}
