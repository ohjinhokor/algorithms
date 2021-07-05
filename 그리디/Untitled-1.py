str = input()

words = ["U","C","P","C"]

check = 0

for i in words:
    if i in str:
        check+=1
        str = str[str.find(i)+1:]
        continue
    else:
        print("I hate UCPC")
        break

if check == 4:
    print("I love UCPC")