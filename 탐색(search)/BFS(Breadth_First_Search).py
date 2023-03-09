#가까운 노드부터 탐색합니다. 
#파이썬에서는 주로 큐 자료구조(Collections.deque)에 기초하여 구현합니다.
#O(N)의 수행시간이 걸리며 보통 DFS(Depth First Search)보다 빨리 동작합니다.
from collections import deque

def bfs(graph, start, visited):
    q = deque([start])
    visited[start] = True
    while q:
        v = q.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9

bfs(graph, 1, visited)

#백준 - 16234 https://www.acmicpc.net/problem/16234

# 2차원 배열에서 "며칠동안 ~ "과 같은 count를 해야하는 문제가 나오면 
# 앞서서 나온 예시처럼 visited를 숫자를 사용해 구현하면 된다.

n, l, r = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]   

maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))

def bfs(x, y, index):
    united = []
    united.append((x, y))
    total = maps[x][y]
    q = deque()
    q.append((x, y))
    days[x][y] = index
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and ny >= 0 and nx < n and ny < n and days[nx][ny] == -1:
                key = abs(maps[nx][ny] - maps[x][y])
                if l <= key <= r:
                    united.append((nx, ny))
                    q.append((nx, ny))
                    total += maps[nx][ny]
                    days[nx][ny] = index

    for i in range(len(united)):
        a, b = united[i]
        maps[a][b] = total // len(united)
    
answer = 0

while True:
    days = [[-1] * n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if days[i][j] == -1:
                bfs(i, j, index)
                index += 1
    if index == n * n:
        break 
    answer += 1

