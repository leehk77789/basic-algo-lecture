# 미로탐색

from sys import stdin
from collections import deque

input = stdin.readline


def bfs(graph, n, m):
    queue = deque([(0, 0)])

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue

            if graph[nx][ny] == 1:
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
    return graph[n - 1][m - 1]


n, m = map(int, input().rstrip().split())

graph = []
for _ in range(n):
    tmp = list(map(int, input().rstrip().split()))
    graph.append(tmp)

print(bfs(graph, n, m))
