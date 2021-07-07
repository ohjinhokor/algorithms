str = input()

stack=[]
ppap=["P","P","A","P"]

for i in str:
    stack.append(i)
    if (stack[-4:] == ppap):
        stack.pop()
        stack.pop()
        stack.pop()

if stack == ["P"]:
    print("PPAP")
else:
    print("NP") 