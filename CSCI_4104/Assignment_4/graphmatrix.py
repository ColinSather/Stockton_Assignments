

# Student Name: Colin Sather
#
# Programming Assignment 4
#
# What to Submit: Submit the following files once you complete
# the assignment:
# (a) This file: graphmatrix.py
# (b) If you do the extra credit part, then please include a
#     a specific highway graph that you used when you tested your
#     implementation (the actual highway graph file). They sometimes
#     update the data in those files, so I want to make sure I
#     have exactly what you tested with.
#
# A few notes before you begin:
# - As in previous assignments, you are not allowed to change the
#   names of files, classes, methods, parameters, etc. If you are wondering
#   why I have this requirement, it is because you will often find
#   yourself (such as in future jobs) tasked with implementing an
#   interface designed by someone else.  For example, in a large project,
#   smaller groups may be tasked with developing smaller parts of a
#   much larger system after the interface has been defined.  If you
#   change part of the interface without consulting the team as a
#   whole, you will break the entire system.  It is also common in
#   test-driven development for a different team to implement the
#   test cases in code from the interface alone.
#   In homework assignments, if you change the interface that I provided
#   (i.e., names of classes, methods, parameters, etc), then the
#   larger system you are breaking is the system comprised of your
#   algorithm implementations along with my test cases that I use when
#   grading.  If I have to either modify your code or my test cases
#   when grading your assignment, then you lose significant points.

# - You are also not allowed to change the names of any attributes
#   that I provided, which in this case is simply _W, although in your
#   code you will need to remember to use the self reference to
#   access it, such as with self._W
#


class WeightedAdjacencyMatrix :
    """A weighted graph represented as a matrix."""

    __slots__ = ['_W']

    def __init__(self, size, edges=[], weights=[]) :
        """Initializes a weighted adjacency matrix for a graph with size nodes.

        Graph is initialized with size nodes and a specified set of
        edges and edge weights.
        
        Keyword arguments:
        size -- Number of nodes of the graph.
        edges -- a list of ordered pairs (2-tuples) indicating the
                 edges of the graph.  The default value is an empty list
                 which means no edges by default.
        weights -- a list of weights for the edges, which should be the same
                   length as the edges list.  The position of a value in
                   the weights list corresponds to the edge in the same
                   position of the edges list.
        """
        for node in range(size):
            #edges[node] = 0
            self._W = 0

    def addEdge(self, u, v, weight) :
        """Adds an undirected edge between u to v with the specified weight.

        Keyword arguments:
        u -- vertex id (0-based index)
        v -- vertex id (0-based index)
        weight -- edge weight
        """
        pass

    def floydWarshall(self) :
        """Floyd Warshall algorithm for all pairs shortest paths.

        Returns a matrix D consisting of the weights of the shortest
        paths between all pairs of vertices, and a matrix P for
        the predecessors matrix (what the textbook called PI).
        This method MUST NOT change the weight matrix of the graph
        itself.  
        """
        # Your return statement will look something like this one
        # in the comment on the following line.  That is return
        # the two matrices, with the D matrix first.  The return None
        # is just a placeholder so that this is valid Python syntax before
        # you've completed the assignment.  This comment line is
        # more like what it should look like:
        # return D, P
        return None

class WeightedDirectedAdjacencyMatrix(WeightedAdjacencyMatrix) :
    """A weighted digraph represented as a matrix."""

    def addEdge(self, u, v, weight) :
        """Adds a directed edge from u to v with the specified weight.

        Keyword arguments:
        u -- source vertex id (0-based index)
        v -- target vertex id (0-based index)
        weight -- edge weight
        """
        pass
    

def testFloydWarshall() :
    """See assignment instructions at top."""
    pass

def parseHighwayGraphMatrix(filename) :
    """EXTRA CREDIT: Rewrite your highway graph parser from
    assignment 2 here in this function but return a WeightedAdjacencyMatrix
    object from this function. If you had that assignment working,
    then this part of the extra credit should be very easy (i.e.,
    copying and pasting code and then making very minor adjustments
    to use construct and return a WeightedAdjacencyMatrix object
    instead of the other graph type you already have.

    Keyword arguments:
    filename - the name of a highhway graph file.
    """
    return None # temporary return statement until you implement this.

def pairShortestPath(D, P, s, t) :
    """EXTRA CREDIT: This function takes D and P matrices (i.e., what is generated
    by floydWarshall), and a source vertex (where you want to start) and
    destination or target vertex t (where you want to end up) and
    returns a pair: w, path, such that w is the weight of the shortest
    path from s to t (just a simple lookup in the D matrix) and
    path is a Python list of vertex ids starting at s and ending at t
    derived from the P matrix.

    Keyword arguments:
    D - the D matrix
    P - the Pi matrix
    s - the source vertex
    t - the destination vertex
    """
    # Your actual return will look something like this:
    # return w, path
    return None # temporary until you implement this

if __name__ == "__main__" :
    # EXTRA CREDIT: Write code here that:
    #   (a) Gets the name of a highway graph file from the command line
    #       arguments.
    #   (b) Uses parseHighwayGraphMatrix from above to parse that file
    #       into a WeightedAdjacencyMatrix object.
    #   (c) Runs the floydWarshall method on that graph.
    #   (d) Then, prompts the user (use the Python docs to figure out
    #       how to do this) for a source and target vertex, s and t.
    #   (e) Uses pairShortestPath to get the weight of the shortest
    #       path between their chosen s and t, and the path itself.
    #   (f) Outputs the weight and path.
    #   (g) Repeats d, e, and f in a loop until the user indicates they
    #       want to quit.  You can decide how to get that decision from them.

    # Not a part of extra credit used for testing 
    nodecount = 4
    edges = [(1,2), (2,3), (3,4), (1,3)]
    weights = [2, 4, 4, 2]
    x = WeightedAdjacencyMatrix(nodecount, edges, weights)
    print(x._W)


    
