from sys import stdin

width, n = map(int, stdin.readline().split(' '))
parts = list(map(int, stdin.readline().split(' ')))
parts.insert(0, 0)
parts.insert(len(parts), width)
ans = []

for i in range(n + 2):
    for j in range(i + 1, n + 2):
        ans.append(parts[j] - parts[i])

print(' '.join(map(str, sorted(set(ans)))))



