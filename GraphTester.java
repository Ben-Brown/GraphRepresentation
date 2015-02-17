import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ben on 2/6/2015.
 */
public class GraphTester {
    public static void main(String[] args) {
        System.out.println("This is the graph tester.");

        // Create a set of Vertices and Edges
        Set<Vertex> vertSet = new HashSet<Vertex>();


        // Create vertices
        vertSet.add(new Vertex("1"));
        vertSet.add(new Vertex("2"));
        vertSet.add(new Vertex("3"));
        vertSet.add(new Vertex("4"));
        vertSet.add(new Vertex("5"));
        vertSet.add(new Vertex("6"));
        vertSet.add(new Vertex("7"));

        System.out.println("Vertices: " + vertSet.toString());

        // Create edges with graph from the book
        Set<Edge> edgeSet = new HashSet<Edge>();
        edgeSet.add(new Edge(new Vertex("1"), new Vertex("2"), 0));
        edgeSet.add(new Edge(new Vertex("1"), new Vertex("4"), 0));
        edgeSet.add(new Edge(new Vertex("1"), new Vertex("3"), 0));

        edgeSet.add(new Edge(new Vertex("2"), new Vertex("4"), 0));
        edgeSet.add(new Edge(new Vertex("2"), new Vertex("5"), 0));
        edgeSet.add(new Edge(new Vertex("3"), new Vertex("6"), 0));

        edgeSet.add(new Edge(new Vertex("4"), new Vertex("3"), 1));
        edgeSet.add(new Edge(new Vertex("4"), new Vertex("6"), 0));
        edgeSet.add(new Edge(new Vertex("4"), new Vertex("7"), 3));

        edgeSet.add(new Edge(new Vertex("5"), new Vertex("4"), 0));
        edgeSet.add(new Edge(new Vertex("5"), new Vertex("7"), 0));
        edgeSet.add(new Edge(new Vertex("7"), new Vertex("6"), 0));

        System.out.println("Edges: " + edgeSet.toString());

        // Create a graph
        MyGraph graph = new MyGraph(vertSet, edgeSet);

        // Print out the vertices and edges
        System.out.println("Vertices: \n" + graph.vertices());
        System.out.println("Edges: \n" + graph.edges());
        System.out.println("Topological: " + graph.topologicalSort());
        System.out.println("Adjacent to 5: " + graph.adjacentVertices(new Vertex("5")));
        System.out.println("Reachable vertices to 1: " + graph.reachableVertices(new Vertex("4")));
        // Store the shortest path
        LinkedList<Vertex> v1TOv4 = new LinkedList<Vertex>();
        // Store the distance
        //int dist = graph.shortestPath

        //System.out.println("Shortest path test: \nDistance: " + dist + "\nPathway: " + v1TOv4 + "\n");

    }

};


