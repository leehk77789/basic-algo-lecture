#스택 수열
import sys

n = int(sys.stdin.readline())
stack = []
results = []  
next_num = 1 

for _ in range(n):
    num = int(sys.stdin.readline())

    while next_num <= num:
        stack.append(next_num)
        results.append('+')
        next_num += 1

    if stack[-1] == num:
        stack.pop()
        results.append('-')

    #불가능
    else:
        print('NO')
        exit(0) #프로그램을 정상 종료하는 함수 호출


for result in results:
    print(result)
