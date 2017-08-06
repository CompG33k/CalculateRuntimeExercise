/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise.DirectedWeightGraphDataStructure;

import java.util.ArrayList;

/**
 *
 * @author Nick
 */
public class DataStateContainer implements Comparable<DataStateContainer> {
    int runTime;
    Boolean isVisited;
    String pathInformation;
    
    ArrayList<DataState> pathList = new ArrayList<DataState>();
    
    public DataStateContainer(int runTime,String pathInformation, ArrayList<DataState> pathList)
    {
        this.runTime = runTime;
        this.pathInformation = pathInformation;
        this.pathList = pathList;
        isVisited = false;
    }
    
    public Boolean isNodeExist(DataState data)
    {
        return this.pathList.contains(data);
    }
    public ArrayList<DataState> getPathList()
    {
        return this.pathList;
    }
    
    public int getRunTime()
    {
        return this.runTime;
    }
    
    public Boolean getIsVisited()
    {
        return this.isVisited;
    }
    
    public String getPathInformation()
    {
        return this.pathInformation;
    }
    
    public void setIsVisited(Boolean value)
    {
        this.isVisited = value;
        for(DataState current :pathList)
        {
            current.setVisited(value);
        }
    }
    
    @Override public int compareTo(DataStateContainer rhsObject) {
        
        if(this.runTime == rhsObject.runTime)
        {    
            return 0;
        }
        else if (this.runTime > rhsObject.runTime)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
