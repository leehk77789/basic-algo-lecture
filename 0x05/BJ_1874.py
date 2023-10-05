import sys
from collections import deque


def sequence(n: int):
    stk = deque([])
    result = deque([])
    for i in range(1, n + 1):
        if len(stk) == 0:
            num = int(sys.stdin.readline())
        stk.append(i)
        result.append("+")

        while num <= stk[-1]:
            stk.pop()
            result.append("-")
            if len(stk) <= 0:
                break
            else:
                num = int(sys.stdin.readline())
    if len(stk) > 0:
        return False
    else:
        return result


n = int(sys.stdin.readline())
result = sequence(n)
if result is False:
    print("NO")
else:
    for signed in result:
        print(signed)
