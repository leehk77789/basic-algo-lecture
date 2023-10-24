import sys
from collections import deque


def check_good(sentence: str) -> bool:
    check = deque([])
    sentence = deque(list(sentence))
    while sentence:
        tmp = sentence.popleft()
        if check and check[-1] == tmp:
            check.pop()
        else:
            check.append(tmp)

    if check:
        return False
    else:
        return True


n = int(sys.stdin.readline())

cnt = 0
for _ in range(n):
    s = sys.stdin.readline().rstrip()
    if check_good(s) is True:
        cnt += 1

print(cnt)

# ABABBABA
# AABBABBA