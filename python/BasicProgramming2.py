from collections import Counter
from math import floor

n, t = [int(i) for i in input().split(" ")]
arr = [int(i) for i in input().split(" ")]


if t == 1:
    for i in range(n):
        for j in range(n):
            if arr[i] != arr[j] and arr[i] + arr[j] == 7777:
                print("Yes")
                quit()
    print("No")

elif t == 2:
    if len(set(arr)) == n:
        print("Unique")
    else:
        print("Contains duplicate")

elif t == 3:
    i, occ = Counter(arr).most_common()[0]
    if occ > n/2:
        print(i)
    else:
        print(-1)

elif t == 4:
    list.sort(arr)
    if n % 2 == 1:
        print(arr[floor(n/2)])
    else:
        print(arr[n//2-1], arr[n//2])

elif t == 5:
    arr = list(filter(lambda x: 100 <= x <= 999, arr))
    list.sort(arr)
    print(" ".join([str(x) for x in arr]))


