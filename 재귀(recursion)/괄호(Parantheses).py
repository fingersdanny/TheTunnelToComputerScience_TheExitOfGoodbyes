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
        

    

