from sys import stdin
from math import sqrt


def dist(x_1, y_1, x_2, y_2):
    return sqrt((x_1-x_2)**2 + (y_1-y_2)**2)


x1, y1 = map(int, stdin.readline().split(' '))
x2, y2 = map(int, stdin.readline().split(' '))
x3, y3 = map(int, stdin.readline().split(' '))

dist12 = dist(x1, y1, x2, y2)
dist13 = dist(x1, y1, x3, y3)

if dist12 == dist13:
    # swap 1 and 2
    t1, t2 = x1, y1
    x1, y1 = x2, y2
    x2, y2 = t1, t2
elif dist12 > dist13:
    # swap 2 and 3
    t1, t2 = x3, y3
    x3, y3 = x2, y2
    x2, y2 = t1, t2

# now the distance between 1 and 3 is the longest
# compute using the midpoint property
mid_x, mid_y = (x1+x3)/2, (y1+y3)/2
print(str(int(2 * mid_x - x2)), str(int(2 * mid_y - y2)))

