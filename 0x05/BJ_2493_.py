import sys
from typing import List


class Solution:
    def top(self, tower: List[int], n: int) -> List[str]:
        answer = [str(0)] * n
        stack = []

        for i in range(n - 1, -1, -1):
            while stack and tower[i] > tower[stack[-1]]:
                idx = stack.pop()
                answer[idx] = str(i + 1)
            stack.append(i)

        return answer


n = int(sys.stdin.readline())
tower = list(map(int, sys.stdin.readline().split()))
sol = Solution()
answer = sol.top(tower, n)
print(" ".join(answer))
