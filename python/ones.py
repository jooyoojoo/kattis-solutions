from sys import stdin

for line in stdin:
    n = int(line)
    left = 1
    ct = 1

    while left % n != 0:
        left = (left * 10 + 1) % n
        ct += 1

    print(ct)
