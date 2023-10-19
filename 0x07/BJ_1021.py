import sys
from collections import deque

n, k = map(int, input().split())
deq = deque([i+1 for i in range(n)])

m = list(map(int, sys.stdin.readline().split()))

cnt = 0
for i in m:
    med = (len(deq) - 1) // 2
    idx = deq.index(i)
    while idx != 0:
        if idx <= med:
            tmp = deq.popleft()
            deq.append(tmp)
        else:
            tmp = deq.pop()
            deq.appendleft(tmp)
        idx = deq.index(i)
        cnt += 1
    deq.popleft()

print(cnt)