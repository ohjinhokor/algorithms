def solution(n, lost, reserve):
    answer = n

    lost1 = [i for i in lost if i not in reserve]
    reserve2 = [i for i in reserve if i not in lost]
    lost1.sort(reverse=True)
    for i in lost1:
        if i+1 in reserve2:
            reserve2.remove(i+1)
        elif i-1 in reserve2:
            reserve2.remove(i-1)
        else:
            answer= answer-1
    return answer

