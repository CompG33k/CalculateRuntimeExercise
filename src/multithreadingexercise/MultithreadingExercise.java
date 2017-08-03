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
public class MultithreadingExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Data d = new Data(1,2,-1);
        d.run();
        System.out.println("Hello world");
    }
    
}

