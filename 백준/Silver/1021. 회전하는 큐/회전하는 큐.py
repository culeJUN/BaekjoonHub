from collections import deque
import sys
input = sys.stdin.readline

number, num = map(int, input().split())
deque = deque(i for i in range(1, number + 1))
x = list(map(int, input().split()))
count = 0
for i in range(num) :
    while True :
        if deque.index(x[i]) == 0 :
            deque.popleft()
            break
        elif deque.index(x[i]) <= (len(deque) // 2) : 
            deque.append(deque.popleft())
            count += 1 
        else :
            deque.appendleft(deque.pop())
            count += 1

print(count)