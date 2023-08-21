package week2;
import java.util.*;
import java.io.*;

public class day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        List<List<String>> p = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                List<Integer> a = Arrays.asList(i, j, n - 1);
                List<String> b = new ArrayList<>();
                int index = 0;
                for (int k : a) {
                    b.add(s.substring(index, k + 1));
                    index = k + 1;
                }
                p.add(b);
            }
        }

        Set<String> c = new HashSet<>();
        for (List<String> b : p) {
            c.addAll(b);
        }
        List<String> d = new ArrayList<>(c);
        Collections.sort(d);

        int answer = 0;
        for (List<String> b : p) {
            int temp = 0;
            for (String w : b) {
                temp += d.indexOf(w) + 1;
            }
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}