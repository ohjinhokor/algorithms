n = int(input())

array = list(map(int, input().split()))

d = [0]*100

d[0] = [0]*100

d[0] = array[0]
d[1] = max(array[0], array[1])
for i in range(2,n):
    d[i] = max(d[i-1],d[i-2] + array[i])

print(d[n-1])

# 어려웠던 부분은 이전까지의 최댓값을 어떻게 구할 것인가












































