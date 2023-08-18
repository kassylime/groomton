import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class day5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] numbersStr = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        // 정렬
        Sort(numbers);
        // k번째 정수 출력
        System.out.println(numbers[k - 1]);
    }
    // 정렬
    private static void Sort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(compare(arr[i], arr[j])){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 비교
    private static boolean compare(int a, int b) {
        int A = count(a);
        int B = count(b);
        if (A != B){
            return A < B; // 1의 개수가 적은 순으로 정렬
        }
        return a < b; // 10진수를 기준으로 오름차순 정렬
    }

    // 1의 개수 계산
    private static int count(int num) {
        int count = 0;
        while (num > 0){
            if (num % 2 == 1){ // 나머지가 1일 때 수 증가
                count++;
            }
            num /= 2;
        }
        return count;
    }

}
