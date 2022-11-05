from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
maps = [list(input()) for i in range(n)]
queue = [[0, 0]]
maps[0][0] = 1
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

while queue :
    a, b = queue[0][0], queue[0][1]
    del queue[0]
    for i in range(4) :
        x = a + dx[i]
        y = b + dy[i]
        if (0 <= x < n) and (0 <= y < m) and maps[x][y] == '1' :
            queue.append([x, y])
            maps[x][y] = maps[a][b] + 1

print(maps[n - 1][m - 1])