import sys


class Node:
    def __init__(self, data=None, prev=None, next=None):
        self.data = data
        self.prev = prev or self
        self.next = next or self


class LinkedList:
    def __init__(self):
        self.current = Node()
        self.head = Node()

    def is_empty(self) -> bool:
        return self.head.next is self.head

    def add_first(self, data):
        self.current = self.head
        self.add(data)

    def add(self, data):
        node = Node(data, self.current, self.current.next)
        self.current.next.prev = node
        self.current.next = node
        self.current = node

    def remove(self):
        self.current.next.prev = self.current.prev
        self.current.prev.next = self.current.next
        self.current = self.current.prev

    def move_prev(self):
        if self.is_empty() or (self.current.prev.data is None):
            return False
        self.current = self.current.prev

    def move_next(self):
        if self.is_empty() or (self.current.next.data is None):
            return False
        self.current = self.current.next

    def print(self):
        result = ""
        ptr = self.head.next
        while ptr is not self.head:
            result += ptr.data
            ptr = ptr.next
        print(result)


n = int(sys.stdin.readline())
for _ in range(n):
    L = sys.stdin.readline()
    L = L.replace("\n", "")
    lst = LinkedList()

    for char in L:
        if char == "-":
            lst.remove()
        elif char == "<":
            lst.move_prev()
        elif char == ">":
            lst.move_next()
        elif lst.is_empty():
            lst.add_first(char)
        else:
            lst.add(char)
    lst.print()
