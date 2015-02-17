import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
    private Collection<Vertex> myVertices; // the vertices in this graph
    private Collection<Edge> myEdges;       // the edges in this graph

    /**
     * Creates a MyGraph object with the given collection of vertices
     * and the given collection of edges.
     *
     * @param v a collection of the vertices in this graph
     * @param e a collection of the edges in this graph
     */
    public MyGraph(Collection<Vertex> v, Collection<Edge> e) {

        // YOUR CODE HERE
        myVertices = new HashSet<Vertex>();
        myEdges = new HashSet<Edge>();

    }
    // Created MyGraph object
    public MyGraph () {
        // Create a set of vertices and a set of edges
        myVertices = new HashSet<Vertex>();
        myEdges = new HashSet<Edge>();
    }



    /**
     * Return the collection of vertices of this graph
     *
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {

        return myVertices;

    }

    /**
     * Return the collection of edges of this graph
     *
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {

        return myEdges;

    }

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     * i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     *
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    public Collection<Vertex> adjacentVertices(Vertex v) {
        // YOUR CODE HERE
        // Throws an IllegalArgumentException if v does not exist.
        if(!(vertices().contains(v))) {
            throw new IllegalArgumentException();
        }

        // Creates a temporary list to store adjacent vertices
        LinkedList<Vertex> adjVert = new LinkedList<Vertex>();
        //
        for(Edge e: myEdges) {
            if(e.from.equals(v)) {
                adjVert.add(e.to);
            }
        }

        // Convert to a set
        Set<Vertex> adjacentVert = new HashSet<Vertex>();
        adjacentVert.addAll(adjacentVert);

        return adjacentVert;

    }

    /**
     * Return a collection of vertices that are reachable from a given vertex v.
     * A vertex is reachable if a path exists from v to the other vertex.
     *
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices that are reachable from v in the graph
     */
    public Collection<Vertex> reachableVertices(Vertex v) {

        // Create a collection for the reachable vertices
        Set<Vertex> reachable = new HashSet<Vertex>();
        // Create a collection for the boundary
        Set<Vertex> frontier = new HashSet<Vertex>();
        // Create a collection for the new boundary
        Set<Vertex> nextFrontier = new HashSet<Vertex>();

        // add V to the reachable vertices
        reachable.add(v);

        // add V to the frontier
        frontier.add(v);

        // Loop through the frontier
        while (!frontier.isEmpty()) {
            // Create an iterator to trace through the frontier
            Iterator itr = frontier.iterator();

            // Loop through all elements within the frontier
            while (itr.hasNext()) {
                // Create a vertex tracer
                Vertex current = (Vertex) itr.next();
                // Create a set to store outNeighbors of the current
                Set<Vertex> outNodes = outNeighbors(current);

                // Remove all visited outNeighbors
                outNodes.removeAll(reachable);
                // Add all remaining vertices to the nextFrontier
                nextFrontier.addAll(outNodes);
                // Clear the outNodes set
                outNodes.clear();
            }
            // Add all nodes from the next frontier to the reachable nodes
            reachable.addAll(nextFrontier);
            // Set the current frontier to the nextFrontier
            frontier.removeAll(frontier);
            // Add to the nextFrontier
            frontier.addAll(nextFrontier);
            // Clear out the nextFrontier
            nextFrontier.removeAll(nextFrontier);

        }
        return reachable;
    }

    /**
     * Returns a topological sorting of the vertices in the graph.
     *
     * @return an ordered list of vertices in topological sort order
     */

    public List<Vertex> topologicalSort() {
        // Create a set for holding the vertices
        LinkedList<Vertex> vertList = new LinkedList<Vertex>();

        boolean added = false;

        // Use a foreach to check each vertex and test its order
        for (Vertex v : myVertices) {
            // Test sorted vertices
            for (Vertex x : vertList) {
                // If v has fewer inNeighbors, add it to the end of the list
                if (inNeighbors(v).size() < inNeighbors(x).size()) {
                    vertList.add(vertList.indexOf(x), v);// Add at the index of x
                    added = true; // Skips adding the outside loop
                    break;
                }
            }
                if (added) {
                    added = false; // reset add
                    continue;
                }
                // Add it to the end
                vertList.add(v);
            }
            return vertList;
        }



    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     *
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the graph,
     * return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    public int isAdjacent(Vertex a, Vertex b) {
        if(a == null || b == null) {
            throw new IllegalArgumentException("null");
        }
        for (Edge e: myEdges) {
            if(e.from.equals(a) && e.to.equals(b)) {
                return e.w;
            }
        }
        return -1;
    }

    /**
     * Returns the shortest path from a to b in the graph.  Assumes positive
     * edge weights.  Uses Dijkstra's algorithm.
     *
     * @param a    the starting vertex
     * @param b    the destination vertex
     * @param path a list in which the path will be stored, in order, the first
     *             being the start vertex and the last being the destination vertex.  The
     *             list will be empty if no such path exists.  NOTE: the list will be
     *             cleared of any previous data.  path is not expected to contain any data
     *             needed by the method when the method is called.  It is used to allow
     *             us to return multiple values from the function.
     * @return the length of the shortest path from a to b, -1 if no such path
     * exists.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public int shortestPath(Vertex a, Vertex b, List<Vertex> path) {

        // YOUR CODE HERE
        return -1;
    }
    // helper method
    // When provided with a vertex called v
    // It should return a set of all incoming
    // neighbor vertices of v
    public Set<Vertex> inNeighbors(Vertex v) {
        // create an empty set
        Set<Vertex> result = new HashSet<Vertex>();

        for (Edge e: myEdges) {
            if(e.to.equals(v)) {
                result.add(e.from);
            }
        }
        // return the result set
        return result;
    }

    public Set<Vertex> outNeighbors(Vertex v) {
        // create an empty set
        Set<Vertex> result = new HashSet<Vertex>();

        for (Edge e: myEdges) {
            if(e.from.equals(v)) {
                result.add(e.to);
            }
        }
        // return the result set
        return result;
    }

    public Set<Vertex> minNodes(Vertex v) {
        // create an empty set
        Set<Vertex> result = new HashSet<Vertex>();

        for (Vertex node : myVertices){

            Set<Vertex> inNbrs = inNeighbors(node);
            if (inNbrs.isEmpty()) {
                result.add(node);
            }
        }
        // return the result set
        return result;
    }

}