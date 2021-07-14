count = int(input())
milk = []
sum=0

for i in range(count):
    money = int(input())
    milk.append(money)

milk.sort(reverse=True)

for i in range(len(milk)):
    if i%3==2:
        continue
    sum+=milk[i]
print(sum)