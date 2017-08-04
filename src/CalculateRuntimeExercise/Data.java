/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nick
 */
public class Data implements Runnable ,IData {
   

    long TaskId;
    long RunTime;
    long ParentTaskId;
    public Data(long taskId,long runTime,long parentTaskId)
    {
        TaskId = taskId;
        RunTime = runTime;
        ParentTaskId = parentTaskId;
    }
    
    public void run() {
        try {
        
            TimeUnit.SECONDS.sleep(RunTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          //logger.debug("Thread # " + threadId + " is doing this task");
          System.out.println(String.format("TaskId: %x RunTime: %x: ParentId: %d",TaskId,RunTime,ParentTaskId));
    }
    
    public long GetTaskId()
    {
        return TaskId;
    }
    public long GetRunTime()
    {
        return RunTime;
    }
    public long GetParentTaskId()
    {
        return ParentTaskId;
    }
}
