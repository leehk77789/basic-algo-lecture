import sys
from collections import deque

t = int(sys.stdin.readline())

arr = ""
for _ in range(t):
    p = sys.stdin.readline().rstrip()
    p = list(p)
    n = int(sys.stdin.readline())

    arr = sys.stdin.readline().rstrip()
    arr = arr[1:-1].split(",")

    if n == 0:
        arr = deque([])
    else:
        arr = deque(arr)

    check = "front"
    try:
        for idx, command in enumerate(p):
            if command == "R":
                if check == "front":
                    check = "back"
                else:
                    check = "front"
            elif command == "D":
                if check == "front":
                    arr.popleft()
                else:
                    arr.pop()
        if check == "back":
            arr.reverse()
        print(f"[{','.join(arr)}]")
    except IndexError:
        print("error")
