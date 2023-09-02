package week3;

import java.util.*;

class day4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 그래프 정보 입력 받기
        int N = scanner.nextInt(); // 정점 개수
        int M = scanner.nextInt(); // 간선 개수
        int K = scanner.nextInt(); // 시작 노드의 번호

        // 그래프 구성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            // 노드의 존재 여부 확인 및 초기화
            graph.computeIfAbsent(s, k -> new ArrayList<>());
            graph.computeIfAbsent(e, k -> new ArrayList<>());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int[] visited = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        int answer = 0; // 방문한 노드 개수
        int currentNode = K; // 마지막으로 방문한 노드 번호

        while (!q.isEmpty()) {
            currentNode = q.poll();
            visited[currentNode] = 1;
            answer++;
            List<Integer> tempNodes = graph.get(currentNode);

            if (tempNodes != null && !tempNodes.isEmpty()) {
                // 다음 노드를 번호가 작은 순으로 정렬
                Collections.sort(tempNodes);
                boolean found = false;

                for (int nextNode : tempNodes) {
                    if (visited[nextNode] == 0) {
                        q.add(nextNode);
                        found = true;
                        break;
                    }
                }

                // 다음 노드를 찾지 못한 경우, 더 이상 갈 곳이 없음
                if (!found) {
                    break;
                }
            }
        }

        System.out.println(answer + " " + currentNode);
    }
}
