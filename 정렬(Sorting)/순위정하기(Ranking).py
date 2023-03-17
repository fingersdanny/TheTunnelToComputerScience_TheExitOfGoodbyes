#정렬되어 있지 않은 배열에서 각 요소의 순위를 구해야할 때
#각 요소마다 배열안에 있는 자기 자신을  제외한 모든 요소와 비교하여
#순위를 구할 수 있다

#시간 복잡도 O(N ** 2)

array = [6, 2, 3, 4, 5, 1]
result = []
for i in range(len(array)):
    count = 0
    for j in range(len(array)):
        if array[j] > array[i]:
            count += 1
    result[i] = count + 1

#결과 값 : [1, 5, 4, 3, 2, 6]