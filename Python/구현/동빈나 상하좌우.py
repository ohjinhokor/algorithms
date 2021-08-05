MAX = int(input())

total = input().split()
X = 1 #  x 좌표 
Y = 1 #  y 좌표

for i in total:
    if i == "R":
        if X == MAX:
            pass
        else :
            X = X+1    

    elif i == "L":
        if X == 1:
            pass
        else :
            X = X-1          

    elif i == "U":
        if Y == 1:
            pass
        else :
            Y = Y-1

    elif i == "D":
        if Y == MAX:
            pass
        else :
            Y = Y+1

print(Y, X )