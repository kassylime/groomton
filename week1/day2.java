package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class day2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] time = new int[N];
        for(int i = 0; i < N; i++){
            time[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int total = T * 60 + M;
        for(int i = 0; i < N; i++){
            total += time[i];
            if(total >= 24 * 60){
                total %= 24 * 60;
            }
        }

        int hour = total / 60;
        int minute = total % 60;
        System.out.println(hour + " " + minute);
    }
}