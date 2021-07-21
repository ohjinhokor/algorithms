N, M = map(int,input().split())

result =0

for i in range(N):
    card = list(map(int,input().split()))
    if result < min(card):
        result = min(card)
    
print(result)