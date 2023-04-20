/// 모든 노드에서 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
/// 거쳐가는 노드를 기준으로 알고리즘을 수행한다.
/// 노드의 개수가 N개일때 단계마다 O(N^2)의 연산을 통해 현재 노드를 거쳐가는 모든 경로를 고려한다.
/// 시간 복잡도: O(N^3)

import java.util.Scanner;

class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int INF = 1_000_000_000;

        //자기 자신에게 가는 비용을 0으로 초기화 그 외의 비용은 무한대로 설정
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        // 각 간선에 대한 정보를 받아서 초기화
        for (int k = 0; k < m; k++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 수행
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INFINITY");
                } else {
                    System.out.print(graph[i][j]);
                }
            }
        }
    }
}

'''
input
4
7
1 2 4  
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
'''