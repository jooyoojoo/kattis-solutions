from sys import stdin

ops = ['*', '//', '+', '-']
combinations = {}

for op1 in ops:
    for op2 in ops:
        for op3 in ops:
            exp = '4 ' + op1 + ' 4 ' + op2 + ' 4 ' + op3 + ' 4'
            res = eval(exp)
            combinations[res] = exp

for i in range(0, int(stdin.readline())):
    x = int(stdin.readline())
    if x in combinations:
        print(combinations[x].replace('//', '/') + ' = ' + str(x))
    else:
        print('no solution')
