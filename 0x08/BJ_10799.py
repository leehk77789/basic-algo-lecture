# 백준 10799번 쇠막대기 문제

from sys import stdin
from collections import deque


def get_number_of_stick(s: str) -> int:
    total = 0
    stk = deque([])
    open_bracket = "("
    close_bracket = ")"
    s = deque(s)
    while s:
        bracket = s.popleft()
        if bracket == open_bracket and s[0] == close_bracket:
            s.popleft()
            if stk:
                stk[-1] += 1
        elif bracket == "(":
            stk.append(0)
        elif stk and bracket == ")":
            tmp = stk.pop()
            if stk:
                stk[-1] += tmp
            total += tmp + 1

    return total


string = stdin.readline().rstrip()
print(get_number_of_stick(string))
