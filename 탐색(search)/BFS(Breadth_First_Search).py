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

#BFS + 며칠동안 예제

#백준 - 16234 https://www.acmicpc.net/problem/16234

# visited를 새로운 2차원 배열로 구현 후 어느 나라가 연합됐었는지 확인.

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

# 백준 - 7576 https://www.acmicpc.net/problem/7576

# 맨 처음 익은 토마토를 0으로 그 다음 익은 토마토 바로 옆에서 익은 토마토를 time + 1 해서 
# 모든 토마토가 익을 때까지 얼마나 걸리는지 계산

m, n= map(int, input().split())

blocks = []
ripe = []
for i in range(n):
    blocks.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
                    
def bfs(arr):
    answer = 0
    q = deque()
    for dist in arr:
        q.append(dist)
    while q:
        x, y, time = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if blocks[nx][ny] == -1:
                continue
            if blocks[nx][ny] == 0:
                blocks[nx][ny] = 1
                q.append((nx, ny, time + 1))
                answer = max(answer, time + 1)
    return answer

status = 0

for j in range(n):
    for k in range(m):
        if blocks[j][k] == 1:
            ripe.append((j, k, 0))
        if blocks[j][k] == 0:
            status += 1

if status == 0:
    print(0)
else:
    result = bfs(ripe)
    for j in range(n):
        for k in range(m):
            if blocks[j][k] == 0:
                result = -1
    print(result)   

            