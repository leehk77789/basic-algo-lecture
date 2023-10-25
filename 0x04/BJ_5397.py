from sys import stdin, stdout

input = stdin.readline
print = stdout.write


def find_password(test_case):
    left_stack = []
    right_stack = []
    for command in test_case:
        if command == '-':
            if left_stack:
                left_stack.pop()
        elif command == '<':
            if left_stack:
                right_stack.append(left_stack.pop())
        elif command == '>':
            if right_stack:
                left_stack.append(right_stack.pop())
        else:
            left_stack.append(command)

    password = ''.join(left_stack + list(reversed(right_stack)))
    return password


n = int(input().rstrip())

for _ in range(n):
    test_case = input().rstrip()
    print(find_password(test_case)+"\n")
