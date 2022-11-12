import sys
input = sys.stdin.readline

line = int(input())
map = [list(input()) for _ in range(line)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]              # x[n], y[n]로 보면 좌, 상, 우, 하
count = 0
apt = []

def dfs(x, y) :
    global count 
    map[x][y] = '0'                 # 방문 한 곳을 0으로 바꿈
    count += 1  
    for i in range(4) :
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= line or ny < 0 or nx >= line :
            continue

        if map[nx][ny] == '1' :
            dfs(nx, ny)

for i in range(line) :
    for j in range(line) :
        if map[i][j] == '1' :           # 1 만나는 순간부터 카운트 시작
            count = 0                       # 카운트 초기화 후
            dfs(i, j)                       # 카운트 시작, 세주면서 붙어있는 1은 0으로 바뀌기 때문에 for문 걱정X
            apt.append(count)

print(len(apt))
apt.sort()
for i in apt :
    print(i)