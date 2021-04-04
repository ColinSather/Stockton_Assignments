# Student name: Colin Sather.
import random
import math


def issorted(A) :
    """
    Returns True if A is sorted in non-decreasing order,
    and returns False if A is not sorted.
    Keyword arguments:
    A - a Python list.
    """
    flag = 0
    i = 1
    while i < len(A):
        if A[i-1] > A[i]:
            flag = 1
        i += 1
    if not flag:
        return True
    else:
        return False


def randomlist(length, low_value=0, high_value=100) :
    """
    Generates and returns a Python list of random integer values.
    The integers in the list are generated uniformly at random from
    the interval [low_value, high_value], inclusive of both end points.

    Keyword arguments:
    length - the length of the list.
    low_value - the lower bound for the random integers.
    high_value - the upper bound for the random integers.
    """
    lst = []
    i = 0
    while i < length:
        rando = random.randint(low_value, high_value)
        lst.append(rando)
        i += 1
    return lst


def insertionsort(A):
    """
    Implementation of the insertion sort algorithm
    as specified on page 18 of the textbook.

    Keyword arguments:
    A - a Python list.
    """
    for j in range(1, len(A)):
        key = A[j]
        i = j - 1
        while A[i] > key and i >= 0:
            A[i + 1] = A[i]
            i -= 1
        A[i + 1] = key
    return A


def heapsort(A):
    """
    Implementation of the heapsort algorithm
    as specified on page 160 of the textbook.

    Keyword arguments:
    A - a Python list.
    """
    heapsize = len(A)
    
    def left(i):
        """Returns the index of the left child of i (see page 152)."""
        return 2*i +1

    def right(i):
        """Returns the index of the right child of i (see page 152)."""
        return 2*i +2

    def maxheapify(A, i):
        """
        Performs the max heapify step as specified in the algorithm
        on page 154 of the textbook.

        Keyword arguments:
        A - a Python list.
        i - the root of the subtree to heapify
        """
        nonlocal heapsize

        l = left(i)
        r = right(i)
        if l < heapsize and A[l] > A[i-1]:
            largest = l
        else:
            largest = i
        if r < heapsize and A[r] > A[largest]:
            largest = r
        if largest != i:
            A[i], A[largest] = A[largest], A[i]
            maxheapify(A, largest)

    def buildmaxheap(A) :
        """
        Reorders the elements of list A so that A
        satisfies the max heap property.  Implementation of
        algorithm on page 157 of the textbook.

        Keyword arguments:
        A - a Python list.
        """
        nonlocal heapsize
        heapsize = len(A)
        for i in range(math.floor(heapsize/2), 0, -1):
            maxheapify(A, i)
    
    #  heapsort execution ends after this block
    length = len(A) - 1
    buildmaxheap(A)
    for i in range(length, 1, -1):
        A[0], A[i] = A[i], A[0]
        heapsize = heapsize - 1
        maxheapify(A, 0)


if __name__ == "__main__" :
    ## Indented within this if block, do the following:
    ## 1) Write a few lines of code to demonstrate that your
    ##    issorted works correctly (i.e., that it returns True
    ##    if given a list that is sorted, and False otherwise).
    L = [43, 12, 132, 13]
    M = [1, 2, 3, 4, 7]
    print("\n----------------- Question 1 -----------------\n")
    print(L, "is sorted =", issorted(L)) # returns false
    print(M, "is sorted =", issorted(M), "\n") # returns true

    ## 2) Write a few lines of code to demonstrate that insertionsort
    ##    correctly sorts a list (your randomlist function will be useful
    ##    here).  Output (i.e., with print statements) the contents
    ##    of the list before sorting, and then again after sorting).
    print("----------------- Question 2 -----------------\n")
    A = randomlist(5, 0, 100)
    print("Random unsorted array:", A)
    insertionsort(A)
    print("Post insertion sort:", A, "\n")

    ## 3) Repeat 2 to demostrate that your heapsort sorts correctly.
    print("----------------- Question 3 -----------------\n")
    B = randomlist(5, 0, 100)
    print("Random unsorted array:", B)
    print("Unsorted max-heap:", B)
    heapsort(B)
    print("Sorted max-heap:", B)