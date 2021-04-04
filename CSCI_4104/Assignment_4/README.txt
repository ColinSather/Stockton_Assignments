# Do the following:
# 1) Implement the initializer in the WeightedAdjacencyMatrix class,
#    which should create a matrix (i.e., Python list of Python lists) with
#    number of rows and columns both equal to size (i.e., number of vertices).
#    Carefully read the docstring that I have for the __init__ which explains
#    the parameters.  If edges and weights are empty lists, then the
#    graph should initially have no edges.  Otherwise, initialize it
#    with the edges and weights indicated by those lists.
#    Once the __init__ is complete, the diagonal of the matrix should have
#    all 0s.  For each edge in the edge list, with corresponding weight
#    from the weights list, you should have the weight in 2 positions in
#    the matrix (remember for an undirected graph, the matrix is
#    symmetric).  For all non-edges (other than the diagonal) you must
#    have infinity, which is math.inf in Python (make sure you add the
#    import you need for that at the top).
#
#    Use the attribute I provided above in __slots__ for your
#    matrix _W (see comment above).
#    Remember to use self for an object attribute (i.e., self._W).
#
#    You can delete the pass statement I have in there.  It is just a
#    placeholder until you have implemented this.
#
#    Read the instructions for step 2 before doing step 1.  You will find
#    it useful to have your __init__ call your addEdge implemented in step 2,
#    which will make step 3 of the assignment much easier.
#
#    Hint 1: Have your __init__ start by initializing a 2D list
#            of the appropriate size, with 0s on the diagonal and
#            infinity everywhere else.  And then have it iterate
#            over the edges calling addEdge for each edge, weight pair.
#            This will make doing step 3, with the inheritance as easy
#            as overriding addEdge, without need to override __init__
#
# 2) Implement the addEdge method of the WeightedAdjacencyMatrix class,
#    as specified in its docstring.
#    It is an undirected edge, so you'll need to set two different cells
#    of the matrix (for an undirected graph, the matrix is symmetric
#    as mentioned above).
#
#    You can delete the pass statement I have in there.  It is just a
#    placeholder until you have implemented this.
#
# 3) Override addEdge in the WeightedDirectedAdjacencyMatrix class
#    according to the docstring I've inserted in that method below.
#    Also either ensure that the __init__ from step 1 will work as is
#    in the case of a directed graph, or override it in the
#    WeightedDirectedAdjacencyMatrix so that it correctly handles the
#    directed edge case.  If you followed Hint 1 above, then you will NOT
#    need to override __init__.  And following Hint 1 is the easiest way
#    to get this to work correctly.
#
#    You can delete the pass statement I have in there.  It is just a
#    placeholder until you have implemented this.
#
#    Hint 3: Although defined in the parent class, you are able to directly
#            access _W with self._W in the WeightedDirectedAdjacencyMatrix
#            class since nothing is truly private in Python.
#
# 4) Implement the floydWarshall method in the WeightedAdjacencyMatrix class.
#    Since it is in the parent class, you'll be able to use it with either
#    undirected or directed graphs.  Read the docstring for details of what to
#    implement.
#
#    Your method MUST NOT change self._W.  So make sure when you initialize
#    D, that you make a copy of self._W.  Do NOT do: D = self._W.  That
#    doesn't copy the list, it just assigns an additional reference to it.
#    So, changing D would change self._W.  Also, do NOT do: D = self._W[:].
#    That only does a shallow copy.  Since _W is a 2D list, that will only
#    copy the first dimension.  Well the first dimension contains references
#    to 1D list objects, so although D will be a different list than _W,
#    D[i] will be a reference to the same list object as self._W[i],
#    so changing D[i][j] will change self._W[i][j].  You need to do a
#    deep copy.  To get this correct, you will either need to write a loop
#    that does a slice on each row to copy the rows one at a time.  Or
#    try importing Python's copy module, and take a look at the documentation
#    of the functions in the copy module.  One of them will do the deep copy
#    that you need.
#
# 5) Implement the function testFloydWarshall to test your implementation.
#    Your test should construct a WeightedAdjacencyMatrix object, call the
#    floydWarshall method to compute all pairs shortest paths, and then
#    output the result with print statements.  Make sure you use a case
#    that you know the correct
#    solution, such as a small graph where you compute the solution by hand
#    (perhaps the problem from the problem set) or an example from the textbook
#    might be good since you know the correct solution to that from the book.
#    You can just call the function from the shell.  You don't need to call it
#    from an if main block.  The if main block is for something else for extra
#    credit.  See #6 below.
#
# 6) EXTRA CREDIT: Implement the parseHighwayGraphMatrix function, and the
#    pairShortestPath function, and the if main block at the bottom according to
#    the docstrings and comments I have there indicating what these should do.
#    The extra credit portion is worth up to 25 points.
