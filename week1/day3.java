package week1;

import java.io.*;
class day3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int total = 0;

        for (int i = 0; i < t; i++) {
            String cal = br.readLine();
            String[] value = cal.split(" ");

            int m = Integer.parseInt(value[0]);
            char four = value[1].charAt(0);
            int n = Integer.parseInt(value[2]);

            int result = 0;

            switch (four) {
                case '+':
                    result = m + n;
                    break;
                case '-':
                    result = m - n;
                    break;
                case '*':
                    result = m * n;
                    break;
                case '/':
                    result = m / n;
                    break;
            }

            total += result;
        }
        System.out.println(total);
    }
}