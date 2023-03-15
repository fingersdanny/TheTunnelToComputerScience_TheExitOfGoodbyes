#정렬된 배열에서 탐색 범위를 절반씩 좁혀가면서 원하는 목표값을 찾아냅니다.
#시작점, 중간점, 끝점 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해 원하는 데이터를 찾습니다.

# 시간 복잡도 : O(log(N))
#반복문으로 구현한 이진 탐색

def binary_search(start, end, arr, target):
    while start <= end:
        mid = (start + end) // 2  #중간점
        if arr[mid] == target:  # 중간점이 target과 같은 경우
            index = mid
            break
        if arr[mid] > target:   # 중간점보다 작은 경우
            end = mid - 1
        if arr[mid] < target:   # 중간점 보다 큰 경우
            start = mid + 1
    return index

#이진탐색 심화 : Lower Bound, Upper Bound

#Lower Bound: target 값이 맨 처음 나오는 인덱스 반환

def lower_bound(start, end, arr, target):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return start

#Upper Bound: target 값 보다 큰 값이 처음 나오는 인덱스 반환

def upper_bound(start, end, arr, target):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] <= target:
            start = mid + 1
        else:
            end = mid - 1
    return start

