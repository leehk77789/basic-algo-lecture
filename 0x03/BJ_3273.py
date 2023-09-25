# n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
# ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
# 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는
# (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

from typing import List


# time out version
def count_two_sum(nums: List, target: int) -> int:
    cnt = 0
    for i, num in enumerate(nums):
        diff = target - num
        if diff in nums[i + 1 :]:
            cnt += 1
    return cnt


def count_two_sum2(nums: List, target: int) -> int:
    nums.sort()
    cnt = 0
    left, right = 0, len(nums) - 1
    while left < right:
        tmp = nums[left] + nums[right]
        if tmp == target:
            cnt += 1
            left += 1
        elif tmp < target:
            left += 1
        elif tmp > target:
            right -= 1
    return cnt


n = int(input())
nums = list(map(int, input().split()))
target = int(input())


print(count_two_sum2(nums, target))
