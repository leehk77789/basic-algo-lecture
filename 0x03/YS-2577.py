import sys

a = int(input())
b = int(input())
c = int(input())

abc= a*b*c
strabc = list(str(abc))
for i in range(10):
    print(strabc.count(str(i)))