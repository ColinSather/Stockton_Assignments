# Student name: <put your name here>.
#
# Implement the insertion sort and heap sort
# algorithms in the functions that follow.  Also implement
# the issorted function to check if a list is sorted, and
# the randomlist function to generate a list of random integers.
#
# Make sure that you carefully read the docstrings that I've provided
# for the functions, which specifies what you are to implement.
#
# Don't change the names of the functions or parameters.
# If you find it useful to have additional helper functions,
# you may do so.  Naming conventions in Python for helper functions
# is to begin with an _ at the start of the name.  It tells other programmers
# that you intend for that function to be private, although Python
# doesn't enforce this.
#
# Don't delete the docstrings that I have at the start of the functions
# (the multiline strings that indicate what the functions do).  You can
# feel free to delete comments that I have with hints, etc.
#
# IMPORTANT: Remember that the textbook pseudocode uses 1-based indexing,
# while Python uses 0-based indexing, so you may need to make minor
# adjustments from the pseudocode (pay specific attention to the _left
# and _right helper functions for heapsort).  
#
# Note: You don't need the pass statements that I inserted, so you
# can delete them after you implement the functions.  I put them
# in temporarily so that you have valid syntax to start with.  A function
# requires at least one statement in the body.  The pass statement does
# nothing, but is a statement none-the-less.
#
# IMPORTANT: DO NOT have any print statements in the functions in this
# Python file (e.g., in the issorted, randomlist, insertionsort,
# heapsort, and heapsort's various helper functions).
# In general, you want to separate
# output from the computation.  You'll be outputting results
# (e.g., using print) in the if block at the bottom.


def issorted(A) :
    """Returns True if A is sorted in non-decreasing order,
    and returns False if A is not sorted.

    Keyword arguments:
    A - a Python list.
    """

    pass # here temporarily

    ## Hints for implementing issorted:
    ## Hint 1: DO NOT use the built-in function sorted in this function.
    ##       E.g., if you are tempted to call sorted and then compare
    ##       result to A, this would be wrong (or at least it would be a
    ##       terribly inefficient way to do this.  Python's sorted function
    ##       actually does a sort generating a new list that is a sorted copy
    ##       of the original.  This would be a silly, and costly, way to check
    ##       if your list is sorted.  You will get 0 points for the issorted
    ##       function if you call Python's sorted function.
    ## Hint 2: If A is sorted then A[0] <= A[1] <= A[2] <= ....
    ##       So, you can write a loop whose body does one
    ##       comparison of adjacent elements, returning False if there is a violation
    ##       within the loop. If you manage to get
    ##       through the loop without returning, then the list must be sorted,
    ##       so return True.

def randomlist(length, low_value=0, high_value=100) :
    """Generates and returns a Python list of random integer values.
    The integers in the list are generated uniformly at random from
    the interval [low_value, high_value], inclusive of both end points.

    Keyword arguments:
    length - the length of the list.
    low_value - the lower bound for the random integers.
    high_value - the upper bound for the random integers.
    """

    pass # here temporarily

    ## Hint: Look at the documentation for the random module.
    ## There are useful functions there for generating random numbers.
    ## There are two functions in particular that generate random integers,
    ## One of them includes the upper bound, and the other does not.
    ## Also, don't use the random.sample function.  The random.sample
    ## function doesn't allow repeat selection.

    ## Another hint: You can use a Python list comprehension to
    ## generate the list.

    ## Yet another hint: If you follow the above hints, it is possible
    ## to implement this function with a single line of code,
    ## a return statement with a list comprehension.

def insertionsort(A) :
    """Implementation of the insertion sort algorithm
    as specified on page 18 of the textbook.

    Keyword arguments:
    A - a Python list.
    """
    
    pass  # here temporarily


def heapsort(A) :
    """Implementation of the heapsort algorithm
    as specified on page 160 of the textbook.

    Keyword arguments:
    A - a Python list.
    """
    
    pass  # here temporarily

def _buildmaxheap(A) :
    """Reorders the elements of list A so that A
    satisfies the max heap property.  Implementation of
    algorithm on page 157 of the textbook.
    
    Keyword arguments:
    A - a Python list.
    """
    
    pass  # here temporarily

def _maxheapify(A, i) :
    """Performs the max heapify step as specified in the algorithm
    on page 154 of the textbook.
    
    Keyword arguments:
    A - a Python list.
    i - the root of the subtree to heapify
    """
    
    pass  # here temporarily

def _left(i) :
    """Returns the index of the left child of i (see page 152)."""

    pass  # here temporarily

def _right(i) :
    """Returns the index of the right child of i (see page 152)."""

    pass  # here temporarily





if __name__ == "__main__" :

    ## Indented within this if block, do the following:
    ## 1) Write a few lines of code to demonstrate that your
    ##    issorted works correctly (i.e., that it returns True
    ##    if given a list that is sorted, and False otherwise).
    ## 2) Write a few lines of code to demonstrate that insertionsort
    ##    correctly sorts a list (your randomlist function will be useful
    ##    here).  Output (i.e., with print statements) the contents
    ##    of the list before sorting, and then again after sorting).
    ## 3) Repeat 2 to demostrate that your heapsort sorts correctly.

    pass # here temporarily

