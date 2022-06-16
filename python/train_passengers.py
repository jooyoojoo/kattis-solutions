from sys import stdin


def solution():
    c, n = map(int, stdin.readline().split(' '))
    in_train = 0

    for i in range(n):
        left, enter, wait = map(int, stdin.readline().split(' '))
        if i == 0 and left != 0:
            return False
        elif i == n-1 and (wait != 0 or enter != 0 or left != in_train):
            return False

        if enter > c or left > in_train:
            return False

        in_train += enter - left
        if in_train > c:
            return False
        if in_train < c and wait != 0:
            return False

    return True


if solution():
    print('possible')
else:
    print('impossible')