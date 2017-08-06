/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise.DirectedWeightGraphDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Nick
 */
public class Graph {
    private int numVertices;
    private Map<MapNode, HashSet<MapEdge>> vertices;

    public Graph(){
        numVertices = 0;
        vertices = new HashMap<MapNode, HashSet<MapEdge>>();
    }

    public void addEdge(MapNode source, MapNode destination, double distance)
    {
        if(vertices.containsKey(source))
        {
            MapEdge map_edge = new MapEdge(source, destination, distance);
            vertices.get(source).add(map_edge);
            System.out.println(String.format("Edge Added with Vertex m%d with Vertex m%d at Runtime(weight) %d added",source.getTaskId(),destination.getTaskId(),source.getData().getRunTime() ));
            source.addEdge(map_edge);
        }
        else
        {
            System.out.println("Source vertex not found..");
        }

    }
    public void addVertex(MapNode V)
    {
        if(!vertices.containsKey(V))
        {
            vertices.put(V, new HashSet<MapEdge>());
            System.out.println(String.format("Vertex m%d Added", V.getTaskId()));
            ++numVertices;
        }
        else
            System.out.println("Vertex already added");
    }
  
    public ArrayList<MapNode> getNeighbor(MapNode vertex)
    {
        return new ArrayList<MapNode>(vertex.getNeighbors());
    }

    // to get distance between verices directly connected to each other
    public double getDistance(MapNode source, MapNode destination)
    {    
        double distance = 0.0;
        for(MapEdge edge : vertices.get(source))
        {
            if(edge.getDestination() == destination)
            {
                distance = edge.getDistance();
                break;
            }
        }
        return distance;
    }

    // No of vertices in graph
    public int numVertices()
    {
        return numVertices;
    }
    
    public Boolean isReachable(MapNode source, MapNode destination)
    {
        // Mark all the vertices as not visited(By default set
        // as false)
        HashSet<MapNode> visited = new HashSet<MapNode>();
        
        // Create a queue for BFS
        LinkedList<MapNode> queue = new LinkedList<MapNode>();
 
        // Mark the current node as visited and enqueue it
        visited.add(source);
        queue.add(source);
 
        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<MapEdge> i;
        while (queue.size()!=0)
        {
            // Dequeue a vertex from queue and print it
            source = queue.poll();
 
            MapEdge n;
            i =  vertices.get(source).iterator();
                
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<MapEdge> t;
            while (i.hasNext())
            {
                n = i.next();
                
                // If this adjacent node is the destination node,
                // then return true
                if (destination.getEdges().contains(n))
                    return true;
 
                // Else, continue to do BFS
                if (!visited.contains(n.getDestination()))// visited[n])
                {
                    visited.add(n.getDestination());
                    queue.push(n.getDestination());
                }
            }
        }
        // If BFS is complete without visited d
        return false;
    }
    
    public DataContainer bfs(MapNode source)
    {
        int totalRuntime = 0;
        Queue<MapNode> queue = new LinkedList<MapNode>();
        HashSet<MapNode> visited = new HashSet<MapNode>();
        ArrayList<Data> returnList = new ArrayList<Data>();
        Stack<String> path = new Stack<String>();
        
        queue.add(source);     
        path.push(String.format("m%d",source.getTaskId()) );
        returnList.add(source.getData());
        
        totalRuntime = source.getData().getRunTime();
        while(!queue.isEmpty())
        {
            MapNode node = queue.poll();
            visited.add(node);
            Set<MapNode> neighbor = node.getNeighbors();
       //     System.out.print(String.format("Node m%d \t" ,node.getTaskId()));
            for(MapNode V : neighbor){
                if(!visited.contains(V))
                {
                    queue.add(V);
                    visited.add(V);
                    returnList.add(V.getData());
                    totalRuntime += V.getData().getRunTime();
                    path.push(String.format("m%d",V.getTaskId()) );
                }
            }
        }
        
        String pathInformation = getPathInformation(path);
        return new DataContainer(totalRuntime,pathInformation,returnList);
    }

    
    private String getPathInformation(Stack<String> path) {
        ArrayList<String> l = new ArrayList<String>();
        while(!path.isEmpty())
        {
            l.add(path.pop());
        }
        return l.toString();
    }
    
}