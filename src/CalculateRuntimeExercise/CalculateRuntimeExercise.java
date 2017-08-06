/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise;

import CalculateRuntimeExercise.DirectedWeightGraphDataStructure.DataState;
import CalculateRuntimeExercise.DirectedWeightGraphDataStructure.DataStateContainer;
import CalculateRuntimeExercise.DirectedWeightGraphDataStructure.Graph;
import CalculateRuntimeExercise.DirectedWeightGraphDataStructure.MapNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;



/**
 *
 * @author Nick
 * 
 */
public class CalculateRuntimeExercise {

    static int MAXTASKIDNUMBER = 10;
    static int MAXRUNTIMENUMBER = 12;
    static int MAXNUMBERTASKS = 7;
    
    static Random rn = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
       // Given data from sheet
       TestCaseLogic(graph);
       // Randomly generated values
       ProductionCode(graph);
       System.out.println("Done");
    }

    private static void TestCaseLogic(Graph graph) {
      
        MapNode m1 = new MapNode(new Data(1,12,1));
        MapNode m2 = new MapNode(new Data(2,2,2));
        MapNode m3 = new MapNode(new Data(3,8,2));
        MapNode m4 = new MapNode(new Data(4,7,2));
        MapNode m5 = new MapNode(new Data(5,11,1));
        MapNode m6 = new MapNode(new Data(6,3,4));
        MapNode m7 = new MapNode(new Data(7,4,7));
        
        graph.addVertex(m1);
        graph.addVertex(m2);
        graph.addVertex(m3);
        graph.addVertex(m4);
        graph.addVertex(m5);
        graph.addVertex(m6);
        graph.addVertex(m7);
        
        graph.addEdge(m1, m1, 12);
        graph.addEdge(m2, m2, 2);
        graph.addEdge(m3, m2, 8);
        graph.addEdge(m4, m2, 7);
        graph.addEdge(m5, m1, 11);
        graph.addEdge(m6, m4, 3);
        graph.addEdge(m7, m7, 4);
        
        DataStateContainer hm1 = graph.bfs(m1);
        DataStateContainer hm2 = graph.bfs(m2);
        DataStateContainer hm3 = graph.bfs(m3);
        DataStateContainer hm4 = graph.bfs(m4);
        DataStateContainer hm5 = graph.bfs(m5);
        DataStateContainer hm6 = graph.bfs(m6);
        DataStateContainer hm7 = graph.bfs(m7);
        
        List<DataStateContainer> list = new ArrayList<DataStateContainer>();
        list.add(hm1);
        list.add(hm2);
        list.add(hm3);
        list.add(hm4);
        list.add(hm5);
        list.add(hm6);
        list.add(hm7);
        
        Collections.sort(list,Collections.reverseOrder());
    
        int i=1;
        int parallelRunTime = 0;
        int sequentialRunTime = 0;
        for(DataStateContainer current: list)
        {
            System.out.println(String.format("Task %d", i++));
            System.out.println(String.format("Runtime: %s Path %s",current.getRunTime(),current.getPathInformation()));
            List<DataState> inList = current.getPathList();
            for(DataState currentData : inList)
            {
              System.out.println(String.format("m%s RunTime %s",currentData.getTaskId(), currentData.getRunTime()));
            }
            
            sequentialRunTime += current.getRunTime();
            if(parallelRunTime < current.getRunTime())
                parallelRunTime = current.getRunTime();
            
            System.out.println("-----");
        }        
        System.out.println("// ======================================================== //");
        System.out.println("//                                                          //");
        System.out.println("//                     TestCase                             //");
        System.out.println("//                                                          //");
        System.out.println("// ======================================================== //");
        System.out.println(String.format("a.) Serially Runtime : %d seconds  ", sequentialRunTime));
        System.out.println(String.format("b.) Parallel Runtime : %d seconds  ", parallelRunTime));
        System.out.println("// ======================================================== //");
        System.out.println("");
    }
    
    private static void ProductionCode(Graph graph) {
        HashSet<MapNode> mapList = getMapList();        
        AddMapEdges(mapList, graph);
        
        List<DataStateContainer> list = getDataStateContainerList(mapList, graph);
        // This is sorted by Runtime in Seconds... (overloaded)
        Collections.sort(list,Collections.reverseOrder());
    
        int i=1;
        int parallelRunTime = 0;
        int sequentialRunTime = 0;
        for(DataStateContainer current: list)
        {
            System.out.println(String.format("Task %d", i++));
            System.out.println(String.format("Runtime: %s Path %s",current.getRunTime(),current.getPathInformation()));
            List<DataState> inList = current.getPathList();
            for(DataState currentData : inList)
            {
              System.out.println(String.format("m%s RunTime %s",currentData.getTaskId(), currentData.getRunTime()));
            }
            
            sequentialRunTime += current.getRunTime();
            if(parallelRunTime < current.getRunTime())
                parallelRunTime = current.getRunTime();
            
            System.out.println("-----");
        }
        
        System.out.println("// ======================================================== //");
        System.out.println("//                                                          //");
        System.out.println("//                     Random Generated                     //");
        System.out.println("//                                                          //");
        System.out.println("// ======================================================== //");
        System.out.println(String.format("a.) Serially Runtime : %d seconds  ", sequentialRunTime));
        System.out.println(String.format("b.) Parallel Runtime : %d seconds  ", parallelRunTime));
        System.out.println("// ======================================================== //");
        System.out.println("");
    }

    private static List<DataStateContainer> getDataStateContainerList(HashSet<MapNode> mapList, Graph graph) {
        List<DataStateContainer> list = new ArrayList<DataStateContainer>();
        for(MapNode source :mapList)
        {
            Data current = source.getData();
            MapNode destination = null;
            for(MapNode v: mapList)
            {
                if(v.getTaskId() == current.ParentTaskId)
                {
                    destination = v;
                    break;
                }
            }
            list.add(graph.bfs(source));
        }
        return list;
    }

    private static void AddMapEdges(HashSet<MapNode> mapList, Graph graph) {
        for(MapNode source :mapList)
        {
            graph.addVertex(source);
            Data current = source.getData();
            MapNode destination = null;
            for(MapNode v: mapList)
            {
                if(v.getTaskId() == current.ParentTaskId)
                {
                    destination = v;
                    break;
                }
            }
            graph.addEdge(source,destination , current.RunTime);
        }
    }
    
    static HashSet<MapNode> getMapList()
    {
        HashSet<MapNode> mapList = new HashSet<MapNode>();
        int[] taskIdList = getTaskIdList();
        int[] runTimeList = getRunTimeList();
        int[] parentTaskIdList = getParentTaskIdList();        
        
        for(int i =0; i < MAXNUMBERTASKS;i++)
        {
            int taskId = taskIdList[i];
            int runTime = runTimeList[i];
            int parentTaskId = parentTaskIdList[i];
            
            mapList.add(new MapNode(
                            new Data(taskId,runTime,parentTaskId)
                        ));
        }
        return mapList;
    }
    
    
    static int[] getTaskIdList()
    {
        int[] l = new int[MAXNUMBERTASKS];
        for(int i = 0; i < MAXNUMBERTASKS; i++)
        {
            l[i]=i+1;
        }
        return l;
    }
    
    static int[] getRunTimeList()
    {
        int[] l = new int[MAXNUMBERTASKS];
        for(int i = 0; i < MAXNUMBERTASKS; i++)
        {
            l[i]=rn.nextInt(MAXRUNTIMENUMBER)+1;
        }
        return l;
    }
    
     static int[] getParentTaskIdList() 
    {
        int[] l = new int[MAXNUMBERTASKS];
        for(int i = 0; i < MAXNUMBERTASKS; i++)
        {
            l[i]= rn.nextInt(MAXNUMBERTASKS)+1;
        }
        return l;
    }
}

