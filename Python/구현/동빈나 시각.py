# time = int(input())

# H = 0
# M = 0
# S = 0

# count_ =0

# while True:
#     S= S+1
#     if S == 60:
#         S=0
#         M = M+1
#         if M==60:
#             M=0
#             H+1
#             if H == time:
#                 break
#     print(H, M, S)

"""
코드가 너무 비효율적임

아래 코드로 수정

IF 문의 시간복잡도 알아볼 것
"""

Max = int(input())

count =0

for i in range(Max+1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i)+str(j)+str(k):
                count = count+1
            
print(count)