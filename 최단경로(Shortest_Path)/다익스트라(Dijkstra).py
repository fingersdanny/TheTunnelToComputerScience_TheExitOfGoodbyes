#특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
#음의 간선이 없어야 함
#heapq 혹은 PriorityQueue를 사용해서 시작 노드에서 제일 가까운 노드를 고르고 갈 수 있는 최단 경로의 간선을 골라서 길이에 넣습니다. 
#시간 복잡도: O(Elog(V)) V = 노드의 개수 E = 간선의 개수

import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())
graph = [[] for i in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print(-1)
    else:
        print(distance[i])

'''
input

6 11
1
1 2 2
1 3 5
1 4 1
2 3 3 
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
'''