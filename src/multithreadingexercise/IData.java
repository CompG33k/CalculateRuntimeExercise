/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadingexercise;

/**
 *
 * @author Nick
 */
public interface IData {
    public long GetTaskId();
    public long GetRunTime();
    public long GetParentTaskId();
}
