'''
    Question:
        find a pair of 2 elements in an arry that can be a factor of a given integer

    candidate qn: what happens to square number case? e.g. 4, 9, 16
        need 2 occurance of the same int?

    candidate qn: what is the expected return type?

    candidate qn: are we happy with the first pair or all possible pairs?
'''
def find_pair(a: list, n: int):

    res = []

    # we don't want to check pair like (a[2], a[2]) so adjust the range that stretch to the second last
    for i1 in range(0, len(a)-1):
        # if current number is not a factor of n, skip
        if n % i1 != 0:
            continue
        for i2 in range(i1 + 1, len(a)):
            if a[i1] * a[i2] == n:
                # 2 layers of brackets
                res.append(tuple((a[i1], a[i2])))

    return res