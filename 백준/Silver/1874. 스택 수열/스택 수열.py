import sys
input = sys.stdin.readline

stack = []
answer = []

flag = 1
current = 1

num = int(input())

for i in range(num) :
    n = int(input())
    
    while current <= n :
        stack.append(current)
        answer.append('+')
        current += 1

    if n == stack[-1] :
        del stack[-1]
        answer.append('-')
    else :
        print('NO')
        flag = 0
        break

if flag :
    for i in answer :
        print(i)