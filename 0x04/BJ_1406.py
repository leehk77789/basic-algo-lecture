import sys
from typing import Any


class Node:
    def __init__(self, data: Any = None, prev: Any = None, next: Any = None):
        self.data = data
        self.prev = prev or self
        self.next = next or self


class LinkedList:
    def __init__(self):
        self.head = self.current = Node()
        self.cursor = 0

    def is_empty(self) -> bool:
        """리스트가 비었는지 확인"""
        return self.head.next is self.head

    def add_first(self, data: Any):
        """맨 앞에 노드 추가"""
        self.current = self.head
        self.add(data)

    def prev(self) -> bool:
        """커서를 왼쪽으로 한 칸 이동"""
        if self.is_empty() or self.current.prev is self.head:
            if self.cursor != 0:
                self.cursor -= 1
            return False
        self.current = self.current.prev
        self.cursor -= 1
        return True

    def next(self) -> bool:
        """커서를 오른쪽으로 한 칸 이동"""
        if self.is_empty() or self.current.next is self.head:
            return False
        elif self.cursor == 0:
            self.cursor += 1
            return False
        self.current = self.current.next
        self.cursor += 1
        return True

    def remove(self):
        """커서 왼쪽에 있는 문자를 삭제함(현재 노드 삭제)"""
        if not self.is_empty():
            self.current.next.prev = self.current.prev
            self.current.prev.next = self.current.next
            self.current = self.current.prev
            self.cursor -= 1

    def add(self, data: Any):
        """노드 추가"""
        node = Node(data, self.current, self.current.next)
        self.current.next.prev = node
        self.current.next = node
        self.current = node
        self.cursor += 1

    def print(self):
        """모든 노드를 출력"""
        res = ""
        ptr = self.head.next
        while ptr is not self.head:
            res += ptr.data
            ptr = ptr.next
        return res

    def print_current_node(self):
        """현재 커서 위치 출력"""
        if self.is_empty():
            print("주목 노드가 없습니다")
        else:
            print(f"현재 노드 데이터: {self.current.data}")
            print(f"현재 커서 위치: {self.cursor}")


string = input()
lst = LinkedList()
for s in string:
    lst.add(s)

n = int(sys.stdin.readline())
for i in range(n):
    command = sys.stdin.readline()
    command = command.replace("\n", "")
    if command == "L":
        lst.prev()
    elif command == "D":
        lst.next()
    elif command == "B":
        if lst.cursor == 0:
            continue
        else:
            lst.remove()
    elif command.split(" ")[0] == "P":
        data = command.split(" ")[1]
        if lst.cursor == 0:
            lst.add_first(data)
        else:
            lst.add(command.split(" ")[1])
    lst.print_current_node()
    print(lst.print())

print(lst.print())
