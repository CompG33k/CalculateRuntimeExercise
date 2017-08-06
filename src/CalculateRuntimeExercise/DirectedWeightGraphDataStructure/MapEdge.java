/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise.DirectedWeightGraphDataStructure;

/**
 *
 * @author Nick
 */
public class MapEdge {
      private MapNode source, destination;
    private double distance;

    public MapEdge(MapNode source, MapNode destination, double distance) {
        this.source = source;
        this.destination= destination;
        this.distance= distance;
    }

    MapNode getSource()
    {
        return this.source;
    }
    MapNode getDestination()
    {
        return this.destination;
    }
    double getDistance()
    {
        return this.distance;
    }
}