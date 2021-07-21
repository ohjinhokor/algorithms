N, K = map(int, input().split())
result =0

while True:
    targetnum = (N//K)*K
    result = result+(N-targetnum)
    N = targetnum

    N = N//K25 5
    result += 1

    if N<K:
        break

result +=N-1
print(result)