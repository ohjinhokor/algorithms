count = int(input())

day =0
treeDay = list(map(int,(input().split())))

treeDay.sort(reverse=True)

for i in range(count):
    day+=1
    treeDay[i]+=day+1

treeDay.sort(reverse=True)

print(treeDay[0])