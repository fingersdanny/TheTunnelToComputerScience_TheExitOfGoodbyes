#한 번 해결한 부분 문제의 정답을 메모리에 미리 저장해, 한 번 계산한 답은 다시 계산하지 않도록 하는 문제 해결 기법입니다.
#점화식을 이용해서 코드로 답을 구하는데, 점화식은 인접한 식들 간의 관계식을 의미합니다.

#Top-down과 Bottom-up 
#Top-down은 재귀함수를 이용하여 더 큰 문제를 해결하기 위해 작은 문제를 호출하는 방식
#Bottom-up은 단순히 반복문을 이용하여 작은 문제를 먼저 해결하고, 해결된 작은 문제를 모아 큰 문제를 해결하는 방식

#예시

#금광

# N*M크기의 금광이 1*1크기의 칸으로 나누어져 있고, 각 칸은 특정 크기의 금이 있다. 
# 채굴차가 첫번째 열에서 출발하여 금을 채굴하는데, 이동은 오른쪽 위, 오른쪽, 오른쪽 아래 3가지만 가능하다. 
# 채굴자가 m번의 이동을 했을때 얻을 수 있는 최대 금의 크기는 ?


t = int(input())
# 이전 열에서 받아올 값의 좌표들을 지정
dx = [0, -1, 1]
dy = [-1, -1, -1]

for _ in range(t):
    n, m = map(int, input().split())
    gold = list(map(int, input().split()))
    answer = 0
    graph = []
    # 입력을 받아서 2차원 배열로 만들기
    for i in range(n):
        graph.append([])
        for j in range(m):
            graph[i].append(gold[i * m + j])
    
    # 1열부터 마지막 열까지 각 행의 이전 열에서의 최댓값을 받아 더해줌
    for y in range(1, m):
        for x in range(n):
            prev_max = 0
            for i in range(3):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx >= n or ny < 0 or ny >= m:
                    continue
                else:
                    prev_max = max(prev_max, graph[nx][ny])
            graph[x][y] += prev_max


    for i in range(n):
        answer = max(answer, graph[i][m - 1])

    for i in range(n):
        for j in range(m):
            print(graph[i][j], end = " ")
        print()

    print(answer)