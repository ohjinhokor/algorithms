def fibo(x):
    if x==1 or x==2:
        return 1
    return fibo(x-1) + fibo(x-2)

print(fibo(4))

# 위처럼 피보나치 수열을 재귀함수로 구현하는건 비효율적


d = [0]*100

def fibo2(x):
    if x == 1 or x == 2:
        return 1
    
    if d[x]!=0:
        return d[x]

    d[x] = fibo2(x-1) + fibo2(x-2)
    return d[x]

print(fibo2(99))

# 탑다운 방식, 메모이제이션기법임. 시간복잡도 : O(N)

d2 =[0]*100

d2[1]=1
d2[2]=1
n=99

for i in range(3, n+1):
    d2[i] = d[i-1] + d[i-2]
    
print(d2[6])

#바텀업 방식(상향식), 재귀 함수의 스택크기가 한정되어 있을 수 있기 때문에 바텀업 방식이 더 효율적이다.
#