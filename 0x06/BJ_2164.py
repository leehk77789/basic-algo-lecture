import sys

class Queue:
    def __init__(self, capacity: int) -> None:
        self.front = self.back = 0
        self.que = [i+1 for i in range(capacity)]
        self.size = capacity
        self.capacity = capacity - 1
        
    def push(self, data: int) -> None:
        self.que[self.back] = data
        if self.back == self.capacity: # 끝에 도달하면
            self.back = 0
        else:
            self.back += 1
        self.size += 1
    
    def pop(self) -> int:
        if self.size == 0: # 들어있는게 없는 경우
            return -1
        n = self.que[self.front]
        if self.front == self.capacity:
            self.front = 0
        else:
            self.front += 1
        self.size -= 1
        return n
            
    def is_empty(self) -> int:
        if self.size == 0:
            return 1
        else:
            return 0
        
    def get_front(self) -> int:
        if self.size == 0:
            return -1
        return self.que[self.front]
    
    def get_back(self) -> int:
        if self.size == 0:
            return -1
        return self.que[self.back - 1]

n = int(sys.stdin.readline())

queue = Queue(n)

while True:
    throw_num = queue.pop()
    if queue.is_empty() == 1:
        break
    num = queue.pop()
    queue.push(num)
print(throw_num)