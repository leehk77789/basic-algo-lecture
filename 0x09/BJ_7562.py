# 나이트의 이동

from sys import stdin
from collections import deque

input = stdin.readline


def bfs(board, n, start, dest):
    dx = [[-2], [2], [-1, 1], [-1, 1]]
    dy = [[-1, 1], [-1, 1], [-2], [2]]

    queue = deque([start])

    if start == dest:
        return 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            for j in range(2):
                if len(dy[i]) == 2:
                    nx = x + dx[i][0]
                    ny = y + dy[i][j]
                elif len(dx[i]) == 2:
                    nx = x + dx[i][j]
                    ny = y + dy[i][0]

                if nx < 0 or ny < 0 or nx >= n or ny >= n:
                    continue

                if board[nx][ny] == 0:
                    queue.append((nx, ny))

                    board[nx][ny] = board[x][y] + 1

                if x == dest[0] and y == dest[1]:
                    break
    return board[dest[0]][dest[1]]


test_n = int(input())

for _ in range(test_n):
    n = int(input())
    tmp = [0] * n
    board = [tmp.copy() for _ in range(n)]

    start = list(map(int, input().split()))
    dest = list(map(int, input().split()))
    print(bfs(board, n, start, dest))
