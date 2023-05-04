## 2개의 자연수에서 최대 공약수를 구하는 알고리즘. 

# 시간복잡도 : O(log(N))
import math

## 재귀
def getGcd(a, b):
    if b == 0:
        return a
    return getGcd(b, a % b)

## 반복
def getGcd(a, b):
    while b != 0:
        if a < b:
            a, b = b, a
        if b == 0:
            return a
        if a % b == 0:
            return b

## 최소공배수
# a, b의 곱에서 최대공약수를 나누어 주면 된다.

# Python에서는 3.9부터 math 라이브러리에서 lcm을 지원한다! 물론 gcd도 있다.