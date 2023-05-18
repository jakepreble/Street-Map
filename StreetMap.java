import bridges.base.Color;
import bridges.base.Edge;
import bridges.base.Element;
import bridges.base.GraphAdjList;
import bridges.data_src_dependent.OsmData;
import bridges.data_src_dependent.OsmEdge;
import bridges.data_src_dependent.OsmVertex;
import java.util.HashMap;
import java.util.HashSet;

public class StreetMap extends GraphAdjList<Integer, Integer, Double> {
    private final int numVertices;

    //create a private record class called VertexInfo with two fields:
    // 1. a double called 'distance' (shortest known distance from start)
    // 2. an integer called 'previous' (previous vertex in path)
    //YOUR CODE HERE:
    private record VertexInfo(double distance, int previous);

    //if there is no previous vertex, 'previous' is set to -1
    private final int NO_PREVIOUS = -1;

    //create a new StreetMap object by converting 'data' into a graph
    public StreetMap(OsmData data) {
        super();

        OsmVertex[] vertices = data.getVertices();
        OsmEdge[] edges = data.getEdges();
        numVertices = vertices.length;

        for(int i = 0; i < numVertices; i++) {
            //add a vertex with key 'i' to the graph
            //set its location to the cartesian coordinates of vertices[i]
            //YOUR CODE HERE:

        }

        for(OsmEdge edge : edges) {
            //add an edge to the graph with the same source and destination as 'edge'
            //then add an edge going in the opposite direction
            //the associated data for both should be edge.getDistance()
            //YOUR CODE HERE:
        }
    }

    //find the vertex with the maximum weight
    //the weight of a vertex is calculated by multiplying its coordinates by 'weightX' and 'weightY'
    //for example, outerVertex(1, 1) returns the northeast vertex, and outerVertex(0, -1) returns the southernnmost
    public int outerVertex(int weightX, int weightY) {
        int index = 0;
        double maxWeight = Integer.MIN_VALUE;

        for(int i = 0; i < numVertices; i++) {
            Element<Integer> point = this.getVertex(i);

            //calculate the weight of 'point'
            //if it is greater than 'maxWeight', update 'maxWeight' and 'index'
            //YOUR CODE HERE:
        }

        return index;
    }

    //find the vertex in 'unvisited' which is closest to the start
    //the distance of vertex 'i' from the start is info().get(i).distance()
    private int nearestUnvisitedVertex(HashMap<Integer, VertexInfo> info, HashSet<Integer> unvisited) {
        //YOUR CODE HERE:
    }

    //draw a path from the starting vertex to 'point'
    private void pathFromStart(HashMap<Integer, VertexInfo> info, int point, Color color) {
        //set the color of vertex 'point' to 'color'
        //YOUR CODE HERE:

        while(info.get(point).previous() != NO_PREVIOUS) {
            //set 'point' to the vertex before it
            //then set the color of vertex 'point' to 'color'
            //YOUR CODE HERE:
        }
    }

    //calculate and draw the shortest path between two vertices given their indices
    public void shortestPath(int start, int end, Color color) {
        HashMap<Integer, VertexInfo> info = new HashMap<>();
        HashSet<Integer> unvisited = new HashSet<>();

        for(int i = 0; i < numVertices; i++) {
            //add 'i' to 'unvisited'
            //YOUR CODE HERE:

            //add a VertexInfo object to 'info' with key 'i'
            //the 'distance' field should be 0 if 'i' is the start vertex, and infinity otherwise
            //the 'previous' field should be NO_PREVIOUS
            //YOUR CODE HERE:
        }

        while(true) {
            int current = nearestUnvisitedVertex(info, unvisited);

            //if the distance value of 'current' is infinity, quit the method with a 'return' statement
            //YOUR CODE HERE:

            //if the current vertex is 'end', use 'pathFromStart' to draw a path
            //then quit the method with a 'return' statement
            //YOUR CODE HERE:

            for(Edge<Integer, Double> edge : this.getAdjacencyList(current)) {
                //get the destination of the edge and assign it to a variable called 'vertex'
                //if 'vertex' has already been visited, go to the next edge with a 'continue' statement
                //YOUR CODE HERE:

                //calculate an alternative distance (distance to 'current' + length of edge)
                //if the alternative is less than the distance already known,
                //  create a new VertexInfo object associated with 'vertex'; the 'distance' field
                //  should be the alternative distance and the 'previous' field should be 'current'
                //YOUR CODE HERE:
            }

            //remove 'current' from 'unvisited'
            //YOUR CODE HERE:
        }
    }
}