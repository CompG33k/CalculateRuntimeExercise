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
public class DataContainer implements Comparable<DataContainer> {
    int runTime;
    String pathInformation;
    
    ArrayList<Data> pathList = new ArrayList<Data>();
    
    public DataContainer(int runTime,String pathInformation, ArrayList<Data> pathList)
    {
        this.runTime = runTime;
        this.pathInformation = pathInformation;
        this.pathList = pathList;
    }
    
    public ArrayList<Data> getPathList()
    {
        return this.pathList;
    }
    
    public int getRunTime()
    {
        return this.runTime;
    }
    
    public String getPathInformation()
    {
        return this.pathInformation;
    }   
    
    @Override public int compareTo(DataContainer rhsObject) {
        
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
