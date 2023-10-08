import sys

# 시간 초과
# class Node:
#     def __init__(self, data=None, prev=None, next=None):
#         self.data = data
#         self.prev = prev or self
#         self.next = next or self
#
#
# class LinkedList:
#     def __init__(self):
#         self.head = self.current = Node()
#
#     def next(self):
#         self.current = self.current.next
#
#     def prev(self):
#         self.current = self.current.prev
#
#     def add_next(self, data):
#         node = Node(data, self.current, self.current.next)
#         self.current.next.prev = node
#         self.current.next = node
#         self.current = node
#
#         if self.current.next.data is None:
#             self.current.next = self.head
#
#     def add_prev(self, data):
#         node = Node(data, self.current.prev, self.current)
#         self.current.prev.next = node
#         self.current.prev = node
#         self.current = node
#
#         if self.current.prev.data is None:
#             self.current.prev = self.head
#
#     def search(self, data, is_NP):
#         while self.current.data != data:
#             self.next()
#
#         if is_NP == "N":
#             if self.current.next is self.head:
#                 return self.head.next.data
#             return self.current.next.data
#
#         elif is_NP == "P":
#             if self.current.prev is self.head:
#                 return self.head.prev.data
#             return self.current.prev.data
#
#     def remove_next(self):
#         self.current.next.next.prev = self.current
#         self.current.next = self.current.next.next
#
#     def remove_prev(self):
#         self.current.prev.prev.next = self.current
#         self.current.prev = self.current.prev.prev
#
#     def print(self):
#         result = []
#         self.current = self.head.next
#         while self.current is not self.head:
#             result.append(self.current.data)
#             self.next()
#         return result


# dictionary 사용
class Node:
    def __init__(self, data=None, prev=None, next=None):
        self.data = data
        self.prev = prev or self
        self.next = next or self


class LinkedList:
    def __init__(self):
        self.head = self.current = Node()
        self.node_map = {}

    def next(self):
        self.current = self.current.next

    def prev(self):
        self.current = self.current.prev

    def add_next(self, data):
        node = Node(data, self.current, self.current.next)
        self.current.next.prev = node
        self.current.next = node
        self.current = node

        if self.current.next is self.head:
            self.head.prev = self.current

        # 추가
        self.node_map[data] = node

    def add_prev(self, data):
        node = Node(data, self.current.prev, self.current)
        self.current.prev.next = node
        self.current.prev = node
        self.current = node

        self.node_map[data] = node

    def search(self, data, is_NP):
        # 추가
        if data in self.node_map:
            self.current = self.node_map[data]

        if is_NP == "N":
            if self.current.next is self.head:
                return self.head.next.data
            return self.current.next.data

        elif is_NP == "P":
            if self.current.prev is self.head:
                return self.head.prev.data
            return self.current.prev.data

    def remove_next(self):
        # 추가
        if self.current.next is self.head:
            del self.node_map[self.head.next.data]

            self.current.next.next.next.prev = self.head
        else:
            del self.node_map[self.current.next.data]

            self.current.next.next.prev = self.current
            self.current.next = self.current.next.next

    def remove_prev(self):
        # 추가
        if self.current.prev is self.head:
            del self.node_map[self.head.prev.data]

            self.current.prev.prev.prev.next = self.head
        else:
            del self.node_map[self.current.prev.data]

            self.current.prev.prev.next = self.current
            self.current.prev = self.current.prev.prev


N, M = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))

lst = LinkedList()
for num in nums:
    lst.add_next(num)

for _ in range(M):
    command = list(map(str, sys.stdin.readline().split()))
    print(command)
    if command[0] == "BN":
        print(lst.search(int(command[1]), "N"))
        lst.add_next(int(command[2]))
    elif command[0] == "BP":
        print(lst.search(int(command[1]), "P"))
        lst.add_prev(int(command[2]))
    elif command[0] == "CN":
        print(lst.search(int(command[1]), "N"))
        lst.remove_next()
    elif command[0] == "CP":
        print(lst.search(int(command[1]), "P"))
        lst.remove_prev()
