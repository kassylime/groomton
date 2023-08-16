package week1;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int rm = (int) (w*(1+(double)r/30));

        System.out.println(rm);
    }
}