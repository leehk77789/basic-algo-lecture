S = input()

alphabet = {chr(k): 0 for k in range(97, 97+26)}
for char in S:
    alphabet[char] += 1
print(" ".join([str(i) for i in alphabet.values()]))
