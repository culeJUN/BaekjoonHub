import sys
input = sys.stdin.readline

n = int(input())
N = sorted(map(int, input().split()))
m = int(input())
M = map(int, input().split())

def binary(i, N, start, end) :
    if start > end :
        return 0
    m = (start + end) // 2
    if i == N[m] :
        return 1
    elif i < N[m] :
        return binary(i, N, start, m - 1)
    else :
        return binary(i, N, m + 1, end)

for i in M :
    start = 0
    end = len(N) - 1
    print(binary(i, N, start, end))