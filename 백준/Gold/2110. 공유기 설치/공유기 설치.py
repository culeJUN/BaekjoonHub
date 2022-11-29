import sys
input = sys.stdin.readline

N, C = map(int, input().split())
house = [int(input()) for _ in range(N)]

def router_count(distance) :
    count = 1
    cur_house = house[0]
    for i in range(1, N) :
        if cur_house + distance <= house[i] :       # 이전 집에서 해당 거리보다 멀리 떨어진 집이라면
            count += 1
            cur_house = house[i]                        # 공유기 설치된 집 갱신
    return count

house = sorted(house)
start = 1
end = house[-1] - house[0]

while start <= end :
    mid = (start + end) // 2
    if router_count(mid) >= C :
        start = mid + 1
    else :
        end = mid - 1

print(end)