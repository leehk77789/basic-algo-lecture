import sys
from typing import List


def cal_accepted(N: int, score: List) -> int:
    cnt = N
    min_score = score[1]
    for i in range(2, N + 1):
        if score[i] > min_score:
            cnt -= 1
        else:
            min_score = score[i]
    return cnt


T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    score = [0] * (N + 1)
    for _ in range(N):
        a, b = map(int, sys.stdin.readline().split())
        score[a] = b
    print(cal_accepted(N, score))
