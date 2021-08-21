N = int(input())
array = []

for i in range(N):
    input_data = input().split()
    array.append((input_data[0],int(input_data[1])))
    print(array)

array.sort(key = lambda student: student[1])

for i in array:
    print(i[0], end =' ')