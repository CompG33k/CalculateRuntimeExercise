/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculateRuntimeExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author Nick
 */
public class CalculateRuntimeExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        
//        Random taskIdRandom = new Random();
//        Random paretnTaskIddRandom = new Random();
//        Random runtimeRandom = new Random();
//             
//        taskIdRandom.nextInt(10);
//        paretnTaskIddRandom.nextInt(10);
//        runtimeRandom.nextInt(10);
//        ExecutorService taskExecutor = Executors.newFixedThreadPool(5);
//        
      
        
      
      //  System.out.println("Distance between Chennai to Mahabalipuram "+graph.getDistance(chennai, mahabalipuram));
        
        Data d = new Data(2,2,-1);
        d.run();
         Data d2 = new Data(3,2,1);
            d2.run();
        System.out.println("Hello world");
    }
    
}

