# from collections import deque

# graph = [
#     [],
#     [2,3,8],
#     [1,7,8],
#     [1,4,5],
#     [3,5],
#     [4,5],
#     [7],
#     [2,6,8],
#     [1,7]
# ]

# visited = [False]*9

# Queue = deque()

# def examplebfs(graph, node, visited):
#     global Queue
#     print("now =",node)
#     for i in graph[node]:
#         if (visited[i] ==False):
#             visited[i] = True
#             Queue.append(i)
#     #print(Queue.popleft())
#     if(len(Queue)!=0):
#         examplebfs(graph, Queue.popleft(), visited)

# examplebfs(graph, 1, visited)

from collections import deque

graph = [
    [],
    [2,3,8],
    [1,7,8],
    [1,4,5],
    [3,5],
    [4,5],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False]*9

def examplebfs(graph, start, visited):
    visited[start] = True
    Queue = deque([start])
    
    while Queue:
        now = Queue.popleft()
        print("now =", now)
        for i in graph[now]:
            if visited[i] == False:
                visited[i] = True
                Queue.append(i)

examplebfs(graph,1,visited)
