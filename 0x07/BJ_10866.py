import sys
from collections import deque

n = int(input())

deq = deque()

for _ in range(n):
    command = sys.stdin.readline()
    command = command.replace("\n", "")
    if command == "pop_front":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.popleft())
    elif command == "pop_back":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.pop())
    elif command == "size":
        print(len(deq))
    elif command == "empty":
        if len(deq) == 0:
            print(1)
        else:
            print(0)
    elif command == "front":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[0])
    elif command == "back":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[-1])
    else:
        commands = command.split()
        if commands[0] == "push_front":
            deq.appendleft(commands[1])
        elif commands[0] == "push_back":
            deq.append(commands[1])
