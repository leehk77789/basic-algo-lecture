# 다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
# 다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
# 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
import math

N = input()
cnt = {str(k): 0 for k in range(10)}
for num in list(N):
    if num == "6":
        cnt["9"] += 1
    else:
        cnt[num] += 1
if cnt["9"] > 1:
    cnt["9"] = math.ceil(cnt["9"] / 2)
print(max(cnt.values()))
