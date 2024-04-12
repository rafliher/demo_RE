

magic = [ 102, 107, 99, 106, 119, 54, 128, 73, 114, 104, 102, 114, 128, 91, 62, 125, 79, 115, 139, 97, 39, 120, 26, 115, 75, 70, 104, 78, 90, 46, 144, 84, 19, 128, 17, 77, 139, 68, 72, 90, 11, 91, 147, 67, 21, 170]

flag = input('What the flag? ')
def gg(inp):
    tmp = []
    for i in range(len(inp)):
        if i % 3 == 0:
            tmp.append(ord(inp[i]) + i & 255)
        if i % 3 == 2:
            tmp.append(ord(inp[i]) ^ i & 255)
        else:
            tmp.append(ord(inp[i]) - i & 255)
    if tmp == magic:
        return 'Correct!!!'
    else:
        return 'Incorrect!!!'
print(gg(flag))
