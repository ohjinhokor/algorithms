# N = int(input())
# n_item = list(map(int,input().split()))

# M = int(input())
# m_item = list(map(int,input().split())) 

# print(n_item)
# print(m_item)

# for i in m_item:
#     if i not in n_item:
#         print("no", end = " ")
#         continue
#     else:
#         print("yes", end = " ")
#         continue

def BinarySearch(array, target, start, end):

    while start<=end:
        mid = (start+end)//2
        if array[mid]==target:
            return mid
        elif array[mid]<target:
            start = mid+1
        else:
            end = mid-1
        

n = int(input())
array = list(map(int,input().split()))
array.sort()

m = int(input())
targets = list(map(int,input().split()))

for i in targets:
    result = BinarySearch(array, i, 0, n-1)

    if result == None:
        print("no", end = " ")
    else:
        print("yes", end=" ")

