# 여러 개의 수가 소수인지 아닌지 판별할 때 사용,
# 1. 2부터 x 까지 모든 수를 나열하고
# 2. 남은 수 중에서 가장 작은 수 i를 찾고
# 3. 남은 수 중에서 i를 제외한 i의 배수를 모두 제거한다.
# 4. 더 이상 반복할 수 없을 때까지 반복한다.

# 시간 복잡도 : O(Nlog(log(N)))

import math

x = 1000
array = [True] * (x + 1)

for i in range(2, int(math.sqrt(x)) + 1):
    if array[i] == True:
        j = 2
        while i * j <= x:
            array[i * j] = False
            j += 1
    
for i in range(2, x + 1):
    if array[i]:
        print(i, end = " ")
