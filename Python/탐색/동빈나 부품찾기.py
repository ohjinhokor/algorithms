N = int(input())
n_item = list(map(int,input().split()))

M = int(input())
m_item = list(map(int,input().split())) 

print(n_item)
print(m_item)

for i in m_item:
    if i not in n_item:
        print("no", end = " ")
        continue
    else:
        print("yes", end = " ")
        continue