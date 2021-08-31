N, M = map(int,input().split())

array = list(map(int,input().split()))

start = 0
end = max(array)
result =0

def binarySearch(array, i, start, end):
    global result

    while start<=end:
        sum =0
        mid = (start+end) //2
        for j in array:
            if j - mid < 0:
                continue
            else:
                sum = sum + (j-mid)

        if sum < i:
            end = mid-1
        elif sum == i:
            result = mid
            return
        else:
            result = mid
            start = mid+1
      
      
binarySearch(array, M, start, end)
print(result)

