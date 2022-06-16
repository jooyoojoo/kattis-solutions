from math import factorial
from sys import stdin
from itertools import combinations


def at_least_200(x):
    return x >= 200


def choose(n, k):
    return factorial(n) // (factorial(k) * factorial(n-k))  # integer division avoids overflow


# Take in inputs
num = int(stdin.readline())
weights = [int(i) for i in stdin.readline().split(" ")]

# Check each combination of 1, 2, and 3 kinds of fruits
# Add the total weights that are at least 200
count = sum(filter(at_least_200, weights))

for i in range(2, num+1):
    if i < 4:
        count += sum(filter(at_least_200, [sum(lst) for lst in combinations(weights, i)]))
    else:
        # Since each kind of fruit weighs at least 50 grams,
        # for combinations of 4 or more fruits, we just count them all
        for weight in weights:
            # number of times each fruit appeared in nCr is (n-1)C(r-1)
            count += weight * choose(num-1, i-1)

print(count)
