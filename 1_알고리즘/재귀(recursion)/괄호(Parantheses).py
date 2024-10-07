from collections import deque

# 완벽한 괄호 문자열 확인 (Valid Parentheses Check) : "(" 와 ")" 의 개수가 같고 짝도 모두 맞을 경우
def valid(string):
    # "()"이 string 안에 있는 동안
    while "()" in string:
        # "()" string을 빈 문자열과 교체
        string = string.replace("()",  "")
    
    # string에 문자열이 남아 있지 않다면:
    if len(string) == 0:
        return True
    
    # string에 문자열이 남아 있다면
    else:
        return False


# 그러나 위와 같이 구현한다면 문자열이 길어지거나 하면 시간 초과가 날 수 있기 때문에 스택을 사용하자.
def valid_with_stack(string):
    q = deque()
    for i in len(string):
        if not q:
            q.append(string[i])
        if q:
            if q[-1] == "(" and string[i] == ")":
                q.pop()
    
    if q:
        return False
    else:
        return True

#균형 잡힌 괄호 문자열 확인 (Baanced Parentheses Check): "(" 와 ")"의 개수가 같은 경우
def balanced(string):
    # 왼쪽 괄호의 개수
    count = 0
    for i in range(len(string)):
        # 왼쪽 괄호의 개수 세기
        if string[i] == "(":
            count += 1
        # 왼쪽 괄호의 개수에서 오른쪽 괄호의 개수 빼기
        else:
            count -= 1

        # 왼쪽과 오른쪽 괄호의 개수가 같다면 그 인덱스 반환
        if count == 0:
            return i
        

    

