class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next


def solve(n, k):
    # 원형 연결 리스트 생성
    head = Node(1)
    cur = head
    for i in range(2, n + 1):
        cur.next = Node(i)
        cur = cur.next
    cur.next = head  # 원형으로 만들기

    print("<", end="")
    while cur.next != cur:
        for _ in range(k - 1):  # k-1번째까지 이동
            cur = cur.next
        print(cur.next.data, end=", ")  # k번째 노드 출력
        cur.next = cur.next.next  # k번째 노드 제거
    print(f"{cur.data}>")  # 마지막 노드 출력


n, k = map(int, input().split())
solve(n, k)
