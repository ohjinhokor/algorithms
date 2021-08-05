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

def exampledfs(graph, node, visited):
    visited[node] = True
    print("now =", node)
    

    for i in graph[node]:
        if visited[i]==False:
            exampledfs(graph ,i, visited)

exampledfs(graph, 1, visited)
