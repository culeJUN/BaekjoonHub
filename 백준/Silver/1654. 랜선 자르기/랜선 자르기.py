import sys 
input = sys.stdin.readline

K, N = map(int, input().split())
lan = [int(input()) for _ in range(K)]
start = 1
end = max(lan)

while start <= end :
    mid = (start + end) // 2
    line = 0
    for i in lan :
        line += i // mid
    
    if line >= N :
        start = mid + 1
    else :
        end = mid - 1

print(end)