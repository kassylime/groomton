package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] P = new int[N+1];
        int[] C = new int[N+1];
        long ans = 0;

        for(int i = 1; i <= N; i++){
            P[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }

        List<double[]> cost = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            cost.add(new double[]{(double) C[i]/ P[i], (double) P[i]});
        }
        Collections.sort(cost, (a, b) -> Double.compare(b[0], a[0]) != 0 ?
                Double.compare(b[0], a[0]) : Double.compare(b[i], a[i]));

        for(int i = 0; i < N; i++){
            double[] pair = cost.get(i);
            double value  = pair[0];
            double amount = pair[1];
            double buy = Math.min(amount, K);
            K -= buy;
            ans += value * buy;
        }
        System.out.println(ans);
    }
}
