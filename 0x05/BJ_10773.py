import sys
from collections import deque

k = int(sys.stdin.readline())

stk = deque([], k)

for _ in range(k):
    n = int(sys.stdin.readline())
    if n == 0:
        stk.pop()
    else:
        stk.append(n)

print(sum(stk))
