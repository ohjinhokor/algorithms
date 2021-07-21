#내 풀이

# N, M, K =  map(int,(input().split()))

# numbers = list(map(int,(input().split())))

# numbers.sort(reverse=True)
# sum=0
# for i in range(M):
#     if i%(K+1) == K:
#         sum = sum+numbers[1]
#     else:
#         sum = sum+numbers[0]

# print(sum)


# 더 효율적인 풀이

N, M, K =  map(int,(input().split()))

numbers = list(map(int,(input().split())))

numbers.sort(reverse=True)
sum=0

count = int(M/(K+1)) * K
count = count + M%(K+1)

sum = sum + numbers[0]*count
sum = sum + numbers[1]*(M-count)

print(sum)
