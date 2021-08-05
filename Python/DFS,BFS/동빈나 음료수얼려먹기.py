N,M = map(int,input().split())

image =[]

for i in range(N):
    temp=[input()]
    print(temp)
    image.append(temp)

#print(image)
count =0

def dfs(x,y):
    global count
    image[x][y] = "P"
    if image[x+1][y] ==0:
        dfs(x+1, y)
        print(x+1, y)
    elif image[x][y+1] ==0:
        dfs(x, y+1)
        print(x, y+1)
    count = count + 1

for i in range(N):
    for j in image[i]:
        dfs(i,j)