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
   
    int TaskId;
    int RunTime;
    int ParentTaskId;
    
    
    public Data(int taskId,int runTime,int parentTaskId)
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
        System.out.println(String.format("TaskId: %x RunTime: %x: ParentId: %d",TaskId,RunTime,ParentTaskId));
    }
    
    public int getTaskId()
    {
        return TaskId;
    }
    public int getRunTime()
    {
        return RunTime;
    }
    public int getParentTaskId()
    {
        return ParentTaskId;
    }
}
