N, M = map(int, input().split())

J = int(input())

count=0
current=1
for i in range(J):
    apple = int(input())
    if(current<=apple and  apple<=current+M-1):
        continue
    else:
        if(apple<current):
            count = count+(current-apple)
            current = current - (current-apple)
        else:
            count = count+(apple-(current+M-1))
            current = current + (apple-(current+M-1))
print(count)