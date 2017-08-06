/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise.DirectedWeightGraphDataStructure;

import CalculateRuntimeExercise.Data;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nick
 */
public class MapNode {

    private Set<MapEdge> edges;
    //private String name;
    //private int taskdId;
    private Data data;
    public MapNode(Data data)
    {
//        this.name = name;
        //this.taskdId = taskId;
        this.data = data;
        edges = new HashSet<MapEdge>();    
    }

    public void addEdge(MapEdge edge)
    {
        edges.add(edge);
    }
     public int getTaskId()
    {
        return this.data.getTaskId();
    }
    public Data getData()
    {
        return data;
    }
//    public String getName()
//    {
//        return new String(this.name);
//    }
    public Set<MapNode> getNeighbors()
    {
        Set<MapNode> neighbor = new HashSet<MapNode>();
        for(MapEdge edge : edges)
        {
            neighbor.add(edge.getDestination());
        }
        return neighbor;
    }

    public Set<MapEdge> getEdges()
    {
        return new HashSet(this.edges);
    }

}
