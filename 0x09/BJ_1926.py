# 그림

from collections import deque
from sys import stdin

input = stdin.readline


def bfs(graph, n, m, area, x, y):
    queue = deque([(x, y)])

    cnt = 1
    while queue:
        x, y = queue.popleft()
        if graph[x][y] == 0:
            return area, False
        else:
            graph[x][y] = 0

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if graph[nx][ny] == 1:
                cnt += 1
                graph[nx][ny] = cnt
                queue.append((nx, ny))
    area.append(cnt)
    return area, True


# n, m = 6, 5
n, m = map(int, input().rstrip().split())

graph = []
for i in range(n):
    tmp = input().rstrip().split()
    tmp = [int(i) for i in tmp]
    graph.append(tmp)


print(graph)
# graph = [
#     [1, 1, 0, 1, 1],
#     [0, 1, 1, 0, 0],
#     [0, 0, 0, 0, 0],
#     [1, 0, 1, 1, 1],
#     [0, 0, 1, 1, 1],
#     [0, 0, 1, 1, 1],
# ]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

area = []

cnt = 0
for i in range(n):
    for j in range(m):
        area, is_picture = bfs(graph, n, m, area, i, j)
        if is_picture is True:
            cnt += 1

print(cnt)
print(max(area))
