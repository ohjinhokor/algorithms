X = int(input())

d = [0]*30001

for i in range(2, X+1):
    d[i] = d[i-1] +1

    if i%2 ==0:
        d[i] = min(d[i],d[i//2]+1)
    if i%3 ==0:
        d[i] = min(d[i],d[i//3]+1)
    if i%5 ==0:
        d[i] = min(d[i],d[i//5]+1)

print(d[X])



# 내 풀이

# N = int(input())

# count =0

# while N != 1:
#     if N % 5==0:
#         N = N/5
#         count +=1
#     elif N<5:
#         if N%2 == 0:
#             N = N//2
#         elif N%3 == 0:
#             N = N//3
#         count +=1
#     else:
#         N = N-1
#         count +=1
# print(count)



