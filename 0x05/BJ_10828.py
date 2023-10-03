import sys
from collections import deque
from typing import Any


class Stack:
    def __init__(self, maxlen: int):
        self.stk = deque([], maxlen)

    def is_empty(self) -> int:
        if not self.stk:
            return 1
        else:
            return 0

    def is_full(self) -> bool:
        return len(self.stk) == self.stk.maxlen

    def push(self, value: Any) -> None:
        if self.is_full():
            return -1
        self.stk.append(value)

    def pop(self) -> int:
        if self.is_empty():
            return -1
        return self.stk.pop()

    def size(self) -> int:
        return len(self.stk)

    def top(self) -> int:
        if self.is_empty():
            return -1
        return self.stk[-1]


n = int(sys.stdin.readline())
stk = Stack(maxlen=n)

for _ in range(n):
    command, num = (lambda x: (x[0], x[1] if len(x) > 1 else None))(
        sys.stdin.readline().split()
    )
    if command == "push":
        stk.push(num)
    elif command == "pop":
        print(stk.pop())
    elif command == "size":
        print(stk.size())
    elif command == "empty":
        print(stk.is_empty())
    elif command == "top":
        print(stk.top())
