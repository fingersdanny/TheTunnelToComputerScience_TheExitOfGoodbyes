# 투포인터 알고리즘 : 배열에 순차적으로 접근해야 할 때 두 개의 점의 위치를 기록하면서 처리하는 알고리즘 입니다.
# 시간 복잡도 : O(N)
# 공간 복잡도 : O(1)

# N개의 수로 된 수열에서 M을 만족하는 부분 수열을 찾을 때 모든 경우의 수를 구하게 된다면
# 배열을 최대 N ^ 2 번 돌아야하므로 시간 복잡도는 O(N ^ 2)이 걸린다.
# 따라서 이를 해결하기 위해 시작점과 끝점을 동시에 기록해 나가며 부분합이 M을 만족한다면
# 이를 출력하도록 설계하는 알고리즘을 투포인터라고 한다.

# 예제 : 프로그래머스 - 연속된 부분 수열의 합
# https://school.programmers.co.kr/learn/courses/30/lessons/178870

def solution(sequence, k):
    sequence.append(int(1e6))
    n = len(sequence)
    
    interval_sum = 0
    s, e = 0, 0
    k_seq = []
    
    while e < n:
        if interval_sum >= k:
            interval_sum -= sequence[s]
            s += 1
        elif interval_sum < k:
            interval_sum += sequence[e]
            e += 1
        
        if interval_sum == k:
            k_seq.append((s, e - 1, e - s))
    
    k_seq.sort(key = lambda x : int(x[2]))
    return [k_seq[0][0], k_seq[0][1]]