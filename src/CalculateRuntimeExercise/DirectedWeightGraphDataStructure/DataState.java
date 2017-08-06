/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise.DirectedWeightGraphDataStructure;

import CalculateRuntimeExercise.Data;
import java.util.Objects;

/**
 *
 * @author Nick
 */
public class DataState extends Data implements Comparable<DataState>{
    
    Boolean visited;
    Boolean pointsToSelf;
    
    public DataState(Data data)
    {
        super(data.getTaskId(),data.getRunTime(),data.getParentTaskId());
        int parentId = data.getParentTaskId();
        pointsToSelf = (parentId == data.getTaskId());
        visited = false;
    }
    
    public Boolean isVisited()
    {
        return visited;
    }
    
    public void setVisited(Boolean value)
    {
        visited= value;
    }
    
     @Override public int compareTo(DataState o) {
        // field comparison
        if( Objects.equals(this.getTaskId(), o.getTaskId())
                && Objects.equals(this.getRunTime(), o.getRunTime())
                && Objects.equals(this.getParentTaskId(), o.getParentTaskId()))
            return 0;
        else if( this.getTaskId() > o.getTaskId()
                && this.getRunTime() > o.getRunTime()
                && this.getParentTaskId() > o.getParentTaskId())            
            return 1;
        else
            return -1;
    }
}
