#정렬된 배열에서 탐색 범위를 절반씩 좁혀가면서 원하는 목표값을 찾아냅니다.
#시작점, 중간점, 끝점 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해 원하는 데이터를 찾습니다.

#반복문으로 구현한 이진 탐색

def binary_search(start, end, arr, target):
    while start <= end:
        mid = start + end // 2
        if arr[mid] == target:
            index = mid
            break
        if arr[mid] > target:
            end = mid - 1
        if arr[mid] < target:
            start = mid + 1
    return index