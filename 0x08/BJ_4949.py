import sys
from collections import deque


def check_balance(sentence: str) -> str:
    bracket_open = ["(", "["]
    bracket_close = [")", "]"]
    check = deque([])
    for char in sentence:
        if char == bracket_open[0]:
            check.append(bracket_close[0])
        elif char == bracket_open[1]:
            check.append(bracket_close[1])

        if char == bracket_close[0]:
            if check and char == check.pop():
                continue
            else:
                return "no"
        elif char == bracket_close[1]:
            if check and char == check.pop():
                continue
            else:
                return "no"

    if check:
        return "no"
    else:
        return "yes"


# s = [
#     "So when I die (the [first] I will see in (heaven) is a score list).",
#     "[ first in ] ( first out ).",
#     "Half Moon tonight (At least it is better than no Moon at all].",
#     "A rope may form )( a trail in a maze.",
#     "Help( I[m being held prisoner in a fortune cookie factory)].",
#     "([ (([( [ ] ) ( ) (( ))] )) ]).",
#     " ."
# ]
# answer: yes, yes, no, no, no, yes, yes
s = sys.stdin.readline().rstrip()
while s != ".":
    print(check_balance(s))
    s = sys.stdin.readline().rstrip()
