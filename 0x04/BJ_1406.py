from sys import stdin, stdout

input = stdin.readline
print = stdout.write


def simple_editor(left_stack, right_stack, command):
    if command[0] == 'L':
        if left_stack:
            right_stack.append(left_stack.pop())
    elif command[0] == 'D':
        if right_stack:
            left_stack.append(right_stack.pop())
    elif command[0] == 'B':
        if left_stack:
            left_stack.pop()
    elif command[0] == 'P':
        left_stack.append(command[2])


initial_string = input().rstrip()
n = int(input().rstrip())
left_stack = list(initial_string)
right_stack = []
for i in range(n):
    command = input().rstrip()
    simple_editor(left_stack, right_stack, command)

print(''.join(left_stack + list(reversed(right_stack))))
